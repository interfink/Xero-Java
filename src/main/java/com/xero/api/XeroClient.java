package com.xero.api;

import com.xero.api.exception.XeroExceptionHandler;
import com.xero.api.jaxb.XeroJAXBMarshaller;
import com.xero.model.*;

import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public class XeroClient {

    private XeroExceptionHandler xeroExceptionHandler;
    private Config config;
    private SignerFactory signerFactory;
    private String token = null;
    private String tokenSecret = null;
    final static Logger logger = Logger.getLogger(XeroClient.class);
    static XeroJAXBMarshaller u = new XeroJAXBMarshaller();
    protected static final DateFormat utcFormatter;

    static {
        utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    protected static final Pattern MESSAGE_PATTERN = Pattern.compile("<Message>(.*)</Message>");
    protected final ObjectFactory objFactory = new ObjectFactory();

    public XeroClient() {
        this(JsonConfig.getInstance());
        this.xeroExceptionHandler = new XeroExceptionHandler();
    }

    public XeroClient(Config config) {
        this(config, new ConfigBasedSignerFactory(config));
        this.xeroExceptionHandler = new XeroExceptionHandler();
    }

    public XeroClient(Config config, SignerFactory signerFactory) {
        this.config = config;
        this.signerFactory = signerFactory;
        this.xeroExceptionHandler = new XeroExceptionHandler();
    }

    public void setOAuthToken(String token, String tokenSecret) {
        this.token = token;
        this.tokenSecret = tokenSecret;
    }

    protected Response get(String endPoint) throws IOException {
        return get(endPoint, null, null);
    }

    protected Response get(String endPoint, Date modifiedAfter, Map<String, String> params) throws IOException {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();

        OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "GET", null, params);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);
        if (modifiedAfter != null) {
            req.setIfModifiedSince(modifiedAfter);
        }

        try {
       		Map<String, String>  resp = req.execute();
       		Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
       		logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
    		logger.error(e);
    		throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }
    /*
     * Deprecated as of 0.7.0 - instead use getInputStream, then save your file 
     * to your storage system (local filesystem, S3, etc)
     */
    @Deprecated
    protected String getFile(String endPoint,
                             Date modifiedAfter,
                             Map<String, String> params,
                             String accept,
                             String dirPath) throws IOException {
    		
    		OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "GET", null, params, accept);
        req.setToken(this.token);
        req.setTokenSecret(this.tokenSecret);
        
        if (modifiedAfter != null) {
            req.setIfModifiedSince(modifiedAfter);
        }
        
        String saveFilePath = null;
        String fileName = null;
    
        try {    	
       		ByteArrayInputStream input = req.executefile();
            fileName = req.getFileName();
			saveFilePath = dirPath + File.separator + fileName;
			
			FileOutputStream output = new FileOutputStream(saveFilePath);

			int DEFAULT_BUFFER_SIZE = 1024;
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int n = 0;

			n = input.read(buffer, 0, DEFAULT_BUFFER_SIZE);

			while (n >= 0) {
			   output.write(buffer, 0, n);
			   n = input.read(buffer, 0, DEFAULT_BUFFER_SIZE);
			}
			
			input.close();
			output.close();
			
			return saveFilePath;	
        } catch (IOException ioe) {
       		logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
    		logger.error(e);
    		throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected ByteArrayInputStream getInputStream(String endPoint,
                                                  Date modifiedAfter,
                                                  Map<String, String> params,
                                                  String accept) throws IOException {
        OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "GET", null, params, accept);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);
        if (modifiedAfter != null) {
            req.setIfModifiedSince(modifiedAfter);
        }

        try {
            ByteArrayInputStream byteStream = req.executefile();
            return byteStream;
        } catch (IOException ioe) {
       		logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
    		logger.error(e);
    		throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected Response put(String endPoint, JAXBElement<?> object) {
        //XeroJAXBMarshaller u = new XeroJAXBMarshaller();

        String contents = u.marshall(object);

        OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "PUT", contents, null);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);
        
        try {
       		Map<String, String> resp = req.execute();
    		Object r = resp.get("content");
    		return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
       		logger.error(ioe);
       		throw xeroExceptionHandler.convertException(ioe);
        } catch (XeroApiException e) {
       		logger.error(e);
       		throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
        }
    }

    protected Response put(String endPoint, String contentType, byte[] bytes) throws IOException {
   		return put(endPoint, contentType, bytes, null);
    }
    	
    protected Response put(String endPoint, String contentType, byte[] bytes, Map<? extends String, ?> params) throws IOException {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();

    	OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "PUT", contentType, bytes, params);
    	
        req.setToken(token);
        req.setTokenSecret(tokenSecret);

        try {
       		Map<String, String> resp = req.execute();
    		Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
       		logger.error(ioe);
   			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
    		logger.error(e);
    		throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected Response put(String endPoint, JAXBElement<?> object, Map<String, String> params) {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();	
    	String contents = u.marshall(object);

        OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "PUT", contents, params);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);

        try {
        	Map<String, String> resp = req.execute();
        	Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
        	logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
	    	logger.error(e);
	    	throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected Response put(String endPoint, String contentType, File file) throws IOException {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();
    	
    	OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "PUT", contentType, file, null);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);

        try {
        	Map<String, String> resp = req.execute();
	    	Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
        	logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
	    	logger.error(e);
	    	throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected Response post(String endPoint, JAXBElement<?> object) throws IOException {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();
    	
    	String contents = u.marshall(object);
        OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "POST", contents, null);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);

        try {
        	Map<String, String> resp = req.execute();
    		Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
        	logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
	    	logger.error(e);
	    	throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected Response post(String endPoint, JAXBElement<?> object, Map<String, String> params) throws IOException {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();
    	
    	String contents = u.marshall(object);
        OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "POST", contents, params);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);

        try {
        	Map<String, String>  resp = req.execute();
        	Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
        	logger.error(ioe);
			throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
	    	logger.error(e);
	    	throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected Response delete(String endPoint) throws IOException {
    	//XeroJAXBMarshaller u = new XeroJAXBMarshaller();
    	
    	OAuthRequestResource req = new OAuthRequestResource(config, signerFactory, endPoint, "DELETE", null, null);
        req.setToken(token);
        req.setTokenSecret(tokenSecret);
    
        try {
        	Map<String, String> resp = req.execute();
        	Object r = resp.get("content");
            return u.unmarshall(r.toString(), Response.class);
        } catch (IOException ioe) {
        	logger.error(ioe);
        	throw xeroExceptionHandler.convertException(ioe);
	    } catch (XeroApiException e) {
	    	logger.error(e);
	    	throw this.xeroExceptionHandler.handleBadRequest(e.getMessage(),e.getResponseCode());
	    }
    }

    protected void addToMapIfNotNull(Map<String, String> map, String key, Object value) {
        if (value != null) {
            map.put(key, value.toString());
        }
    }

    protected <T> T singleResult(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            throw new IllegalStateException("Got multiple results for query");
        }
        return list.get(0);
    }

    //ACCOUNTS
    public List<Account> getAccounts() throws IOException {
        Response responseObj = get("Accounts");
        if (responseObj.getAccounts() == null) {
            ArrayOfAccount array = new ArrayOfAccount();
            return array.getAccount();
        } else {
            return responseObj.getAccounts().getAccount();
        }
    }

    public List<Account> getAccounts(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Accounts", modifiedAfter, params);
        if (responseObj.getAccounts() == null) {
            ArrayOfAccount array = new ArrayOfAccount();
            return array.getAccount();
        } else {
            return responseObj.getAccounts().getAccount();
        }
    }

    public List<Account> createAccounts(List<Account> objects) throws IOException {
        ArrayOfAccount array = new ArrayOfAccount();
        array.getAccount().addAll(objects);
        return put("Accounts", objFactory.createAccounts(array)).getAccounts().getAccount();
    }

    public List<Account> updateAccount(List<Account> objects) throws IOException {
        ArrayOfAccount array = new ArrayOfAccount();
        array.getAccount().addAll(objects);
        return post("Accounts", objFactory.createAccounts(array)).getAccounts().getAccount();
    }

    public Account getAccount(String id) throws IOException {
        return singleResult(get("Accounts/" + id).getAccounts().getAccount());
    }

    public String deleteAccount(String id) throws IOException {
        return delete("Accounts/" + id).getStatus();
    }

    //BANK TRANSACTION
    public List<BankTransaction> getBankTransactions() throws IOException {
        Response responseObj = get("BankTransactions");
        if (responseObj.getBankTransactions() == null) {
            ArrayOfBankTransaction array = new ArrayOfBankTransaction();
            return array.getBankTransaction();
        } else {
            return responseObj.getBankTransactions().getBankTransaction();
        }
    }

    public List<BankTransaction> getBankTransactions(Date modifiedAfter, String where, String order) throws IOException {
        return getBankTransactions(modifiedAfter, where, order, null);
    }

    public List<BankTransaction> getBankTransactions(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("BankTransactions", modifiedAfter, params);
        if (responseObj.getBankTransactions() == null) {
            ArrayOfBankTransaction array = new ArrayOfBankTransaction();
            return array.getBankTransaction();
        } else {
            return responseObj.getBankTransactions().getBankTransaction();
        }
    }


    public List<BankTransaction> getBankTransactions(Date modifiedAfter, String where, String order, String page, String unitdp)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);
        addToMapIfNotNull(params, "unitdp", unitdp);

        Response responseObj = get("BankTransactions", modifiedAfter, params);
        if (responseObj.getBankTransactions() == null) {
            ArrayOfBankTransaction array = new ArrayOfBankTransaction();
            return array.getBankTransaction();
        } else {
            return responseObj.getBankTransactions().getBankTransaction();
        }
    }

    public List<BankTransaction> createBankTransactions(List<BankTransaction> bankTransactions) throws IOException {
        ArrayOfBankTransaction array = new ArrayOfBankTransaction();
        array.getBankTransaction().addAll(bankTransactions);
        return put("BankTransactions", objFactory.createBankTransactions(array)).getBankTransactions().getBankTransaction();
    }

    public List<BankTransaction> createBankTransactions(List<BankTransaction> bankTransactions, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfBankTransaction array = new ArrayOfBankTransaction();
        array.getBankTransaction().addAll(bankTransactions);
        return put("BankTransactions", objFactory.createBankTransactions(array), params).getBankTransactions().getBankTransaction();
    }

    public List<BankTransaction> updateBankTransactions(List<BankTransaction> bankTransactions) throws IOException {
        ArrayOfBankTransaction array = new ArrayOfBankTransaction();
        array.getBankTransaction().addAll(bankTransactions);
        return post("BankTransactions", objFactory.createBankTransactions(array))
            .getBankTransactions()
            .getBankTransaction();
    }

    public List<BankTransaction> updateBankTransactions(List<BankTransaction> bankTransactions, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfBankTransaction array = new ArrayOfBankTransaction();
        array.getBankTransaction().addAll(bankTransactions);
        return post("BankTransactions", objFactory.createBankTransactions(array), params)
            .getBankTransactions()
            .getBankTransaction();
    }

    public BankTransaction getBankTransaction(String id) throws IOException {
        return singleResult(get("BankTransactions/" + id).getBankTransactions().getBankTransaction());
    }

    public BankTransaction getBankTransaction(String id, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);
        return singleResult(get("BankTransactions/" + id, null, params).getBankTransactions().getBankTransaction());
    }

    //BANK TRANSFERS
    public List<BankTransfer> getBankTransfers() throws IOException {
        Response responseObj = get("BankTransfers");
        if (responseObj.getBankTransfers() == null) {
            ArrayOfBankTransfer array = new ArrayOfBankTransfer();
            return array.getBankTransfer();
        } else {
            return responseObj.getBankTransfers().getBankTransfer();
        }
    }

    public List<BankTransfer> getBankTransfers(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        Response responseObj = get("BankTransfers", modifiedAfter, params);
        if (responseObj.getBankTransfers() == null) {
            ArrayOfBankTransfer array = new ArrayOfBankTransfer();
            return array.getBankTransfer();
        } else {
            return responseObj.getBankTransfers().getBankTransfer();
        }
    }

    public List<BankTransfer> createBankTransfers(List<BankTransfer> bankTransfers) throws IOException {
        ArrayOfBankTransfer array = new ArrayOfBankTransfer();
        array.getBankTransfer().addAll(bankTransfers);
        return put("BankTransfers", objFactory.createBankTransfers(array)).getBankTransfers().getBankTransfer();
    }

    public BankTransfer getBankTransfer(String id) throws IOException {
        return singleResult(get("BankTransfers/" + id).getBankTransfers().getBankTransfer());
    }

    //BRANDING THEMES
    public List<BrandingTheme> getBrandingThemes() throws IOException {
        Response responseObj = get("BrandingThemes");
        if (responseObj.getBrandingThemes() == null) {
            ArrayOfBrandingTheme array = new ArrayOfBrandingTheme();
            return array.getBrandingTheme();
        } else {
            return responseObj.getBrandingThemes().getBrandingTheme();
        }
    }

    public List<BrandingTheme> getBrandingThemes(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        Response responseObj = get("BrandingThemes", modifiedAfter, params);
        if (responseObj.getBrandingThemes() == null) {
            ArrayOfBrandingTheme array = new ArrayOfBrandingTheme();
            return array.getBrandingTheme();
        } else {
            return responseObj.getBrandingThemes().getBrandingTheme();
        }
    }

    public BrandingTheme getBrandingTheme(String id) throws IOException {
        return singleResult(get("BrandingThemes/" + id).getBrandingThemes().getBrandingTheme());
    }

    //CONTACT
    public List<Contact> getContacts() throws IOException {
        Response responseObj = get("Contacts");
        if (responseObj.getContacts() == null) {
            ArrayOfContact array = new ArrayOfContact();
            return array.getContact();
        } else {
            return responseObj.getContacts().getContact();
        }
    }

    public List<Contact> getContacts(Date modifiedAfter, String where, String order) throws IOException {
        return getContacts(modifiedAfter, where, order, null, null);
    }

    public List<Contact> getContacts(Date modifiedAfter, String where, String order, String page) throws IOException {
        return getContacts(modifiedAfter, where, order, page, null);
    }

    public List<Contact> getContacts(Date modifiedAfter, String where, String order, String page,
                                     Boolean includeArchived) throws IOException {
        Map<String, String> params = new HashMap<>();
        this.addToMapIfNotNull(params, "Where", where);
        this.addToMapIfNotNull(params, "order", order);
        this.addToMapIfNotNull(params, "page", page);
        this.addToMapIfNotNull(params, "includeArchived", includeArchived);
        Response responseObj = this.get("Contacts", modifiedAfter, params);
        if (responseObj.getContacts() == null) {
            ArrayOfContact array = new ArrayOfContact();
            return array.getContact();
        } else {
            return responseObj.getContacts().getContact();
        }
    }

    public List<Contact> createContact(List<Contact> contacts) throws IOException {
        ArrayOfContact array = new ArrayOfContact();
        array.getContact().addAll(contacts);
        return put("Contacts", objFactory.createContacts(array)).getContacts().getContact();
    }

    public List<Contact> updateContact(List<Contact> contacts) throws IOException {
        ArrayOfContact array = new ArrayOfContact();
        array.getContact().addAll(contacts);
        return post("Contacts", objFactory.createContacts(array)).getContacts().getContact();
    }

    public Contact getContact(String id) throws IOException {
        return singleResult(get("Contacts/" + id).getContacts().getContact());
    }

    //ContactGroups
    public List<ContactGroup> getContactGroups() throws IOException {
        Response responseObj = get("ContactGroups");
        if (responseObj.getContactGroups() == null) {
            ArrayOfContactGroup array = new ArrayOfContactGroup();
            return array.getContactGroup();
        } else {
            return responseObj.getContactGroups().getContactGroup();
        }
    }

    public List<ContactGroup> getContactGroups(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("ContactGroups", modifiedAfter, params);
        if (responseObj.getContactGroups() == null) {
            ArrayOfContactGroup array = new ArrayOfContactGroup();
            return array.getContactGroup();
        } else {
            return responseObj.getContactGroups().getContactGroup();
        }
    }

    public List<ContactGroup> createContactGroups(List<ContactGroup> ContactGroups) throws IOException {
        ArrayOfContactGroup array = new ArrayOfContactGroup();
        array.getContactGroup().addAll(ContactGroups);
        return put("ContactGroups", objFactory.createContactGroups(array)).getContactGroups().getContactGroup();
    }

    public List<ContactGroup> updateContactGroup(List<ContactGroup> objects) throws IOException {
        ArrayOfContactGroup array = new ArrayOfContactGroup();
        array.getContactGroup().addAll(objects);
        return post("ContactGroups", objFactory.createContactGroups(array)).getContactGroups().getContactGroup();
    }

    public ContactGroup getContactGroup(String id) throws IOException {
        return singleResult(get("ContactGroups/" + id).getContactGroups().getContactGroup());
    }

    public List<ContactGroup> deleteContactGroup(ContactGroup object) throws IOException {
        object.setStatus(ContactGroupStatus.DELETED);

        ArrayOfContactGroup array = new ArrayOfContactGroup();
        array.getContactGroup().add(object);
        return post("ContactGroups", objFactory.createContactGroups(array)).getContactGroups().getContactGroup();
    }

    // ContactGroup Contacts
    public List<Contact> createContactGroupContacts(List<Contact> objects, String id) throws IOException {
        ArrayOfContact array = new ArrayOfContact();
        array.getContact().addAll(objects);
        return put("ContactGroups/" + id + "/Contacts", objFactory.createContacts(array)).getContacts().getContact();
    }

    public String deleteSingleContactFromContactGroup(String ContactGroupId, String ContactId) throws IOException {
        System.out.println(ContactGroupId);
        System.out.println(ContactId);
        
        return delete("ContactGroups/" + ContactGroupId + "/Contacts/" + ContactId).getStatus();
    }

    public String deleteAllContactsFromContactGroup(String ContactGroupId) throws IOException {
        return delete("ContactGroups/" + ContactGroupId + "/Contacts").getStatus();
    }

    //CreditNotes
    public List<CreditNote> getCreditNotes() throws IOException {
        Response responseObj = get("CreditNotes");
        if (responseObj.getCreditNotes() == null) {
            ArrayOfCreditNote array = new ArrayOfCreditNote();
            return array.getCreditNote();
        } else {
            return responseObj.getCreditNotes().getCreditNote();
        }
    }

    public List<CreditNote> getCreditNotes(Date modifiedAfter, String where, String order) throws IOException {
        return getCreditNotes(modifiedAfter, where, order, null);
    }

    public List<CreditNote> getCreditNotes(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("CreditNotes", modifiedAfter, params);
        if (responseObj.getCreditNotes() == null) {
            ArrayOfCreditNote array = new ArrayOfCreditNote();
            return array.getCreditNote();
        } else {
            return responseObj.getCreditNotes().getCreditNote();
        }
    }

    public List<CreditNote> createCreditNotes(List<CreditNote> objects) throws IOException {
        ArrayOfCreditNote array = new ArrayOfCreditNote();
        array.getCreditNote().addAll(objects);
        return put("CreditNote", objFactory.createCreditNotes(array)).getCreditNotes().getCreditNote();
    }
    
    
    public List<CreditNote> createCreditNotes(List<CreditNote> objects, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfCreditNote array = new ArrayOfCreditNote();
        array.getCreditNote().addAll(objects);
        return put("CreditNote", objFactory.createCreditNotes(array),params).getCreditNotes().getCreditNote();
    }

    public List<CreditNote> updateCreditNote(List<CreditNote> objects) throws IOException {
        ArrayOfCreditNote array = new ArrayOfCreditNote();
        array.getCreditNote().addAll(objects);
        return post("CreditNotes", objFactory.createCreditNotes(array)).getCreditNotes().getCreditNote();
    }

    public CreditNote getCreditNote(String id) throws IOException {
        return singleResult(get("CreditNotes/" + id).getCreditNotes().getCreditNote());
    }
    
    @Deprecated
    public String getCreditNotePdf(String id, String dirPath) throws IOException {
        return getFile("CreditNotes/" + id, null, null, "application/pdf", dirPath);
    }
    
    public ByteArrayInputStream getCreditNotePdfContent(String id) throws IOException {
        return getInputStream("CreditNotes/" + id, null, null, "application/pdf");
    }

    //CURRENCY
    public List<Currency> getCurrencies() throws IOException {
        Response responseObj = get("Currencies");
        if (responseObj.getCurrencies() == null) {
            ArrayOfCurrency array = new ArrayOfCurrency();
            return array.getCurrency();
        } else {
            return responseObj.getCurrencies().getCurrency();
        }
    }

    public List<Currency> getCurrencies(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Currencies", modifiedAfter, params);
        if (responseObj.getCurrencies() == null) {
            ArrayOfCurrency array = new ArrayOfCurrency();
            return array.getCurrency();
        } else {
            return responseObj.getCurrencies().getCurrency();
        }
    }

    public Currency getCurrency(String id) throws IOException {
        return singleResult(get("Currencies/" + id).getCurrencies().getCurrency());
    }

    //EMPLOYEES
    public List<Employee> getEmployees() throws IOException {
        Response responseObj = get("Employees");
        if (responseObj.getEmployees() == null) {
            ArrayOfEmployee array = new ArrayOfEmployee();
            return array.getEmployee();
        } else {
            return responseObj.getEmployees().getEmployee();
        }
    }

    public List<Employee> getEmployees(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Employees", modifiedAfter, params);
        if (responseObj.getEmployees() == null) {
            ArrayOfEmployee array = new ArrayOfEmployee();
            return array.getEmployee();
        } else {
            return responseObj.getEmployees().getEmployee();
        }
    }

    public List<Employee> createEmployees(List<Employee> objects) throws IOException {
        ArrayOfEmployee array = new ArrayOfEmployee();
        array.getEmployee().addAll(objects);
        return put("Employee", objFactory.createEmployees(array)).getEmployees().getEmployee();
    }

    public List<Employee> updateEmployee(List<Employee> objects) throws IOException {
        ArrayOfEmployee array = new ArrayOfEmployee();
        array.getEmployee().addAll(objects);
        return post("Employees", objFactory.createEmployees(array)).getEmployees().getEmployee();
    }

    public Employee getEmployee(String id) throws IOException {
        return singleResult(get("Employees/" + id).getEmployees().getEmployee());
    }

    //EXPENSE CLAIMS
    public List<ExpenseClaim> getExpenseClaims() throws IOException {
        Response responseObj = get("ExpenseClaims");
        if (responseObj.getExpenseClaims() == null) {
            ArrayOfExpenseClaim array = new ArrayOfExpenseClaim();
            return array.getExpenseClaim();
        } else {
            return responseObj.getExpenseClaims().getExpenseClaim();
        }
    }

    public List<ExpenseClaim> getExpenseClaims(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("ExpenseClaims", modifiedAfter, params);
        if (responseObj.getExpenseClaims() == null) {
            ArrayOfExpenseClaim array = new ArrayOfExpenseClaim();
            return array.getExpenseClaim();
        } else {
            return responseObj.getExpenseClaims().getExpenseClaim();
        }
    }

    public List<ExpenseClaim> createExpenseClaims(List<ExpenseClaim> objects) throws IOException {
        ArrayOfExpenseClaim array = new ArrayOfExpenseClaim();
        array.getExpenseClaim().addAll(objects);
        return put("ExpenseClaim", objFactory.createExpenseClaims(array)).getExpenseClaims().getExpenseClaim();
    }

    public List<ExpenseClaim> updateExpenseClaim(List<ExpenseClaim> objects) throws IOException {
        ArrayOfExpenseClaim array = new ArrayOfExpenseClaim();
        array.getExpenseClaim().addAll(objects);
        return post("ExpenseClaims", objFactory.createExpenseClaims(array)).getExpenseClaims().getExpenseClaim();
    }

    public ExpenseClaim getExpenseClaim(String id) throws IOException {
        return singleResult(get("ExpenseClaims/" + id).getExpenseClaims().getExpenseClaim());
    }

    //INVOICES
    public List<Invoice> getInvoices() throws IOException {
        Response responseObj = get("Invoices");
        if (responseObj.getInvoices() == null) {
            ArrayOfInvoice array = new ArrayOfInvoice();
            return array.getInvoice();
        } else {
            return responseObj.getInvoices().getInvoice();
        }
    }

    public List<Invoice> getInvoices(Date modifiedAfter, String where, String order) throws IOException {
    		Map<String, String> filter = new HashMap<>();
    		return getInvoices(modifiedAfter, where, order, null,null,filter);
    }

    public List<Invoice> getInvoices(Date modifiedAfter, String where, String order, String page) throws IOException {
    		Map<String, String> filter = new HashMap<>();
    		return getInvoices(modifiedAfter, where, order, page, null,filter);
    }
    
    public List<Invoice> getInvoices(Date modifiedAfter, String where, String order, String page, String ids) throws IOException {
        return getInvoices(modifiedAfter, where, order, page,null, ids);
    }

    public List<Invoice> getInvoices(Date modifiedAfter, String where, String order, String page, String unitdp, Map<String, String> filter)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);
        addToMapIfNotNull(params, "unitdp", unitdp);
        for (Map.Entry<String, String> entry : filter.entrySet())
        {
        		addToMapIfNotNull(params, entry.getKey(), entry.getValue());
        }
        
        Response responseObj = get("Invoices", modifiedAfter, params);
        if (responseObj.getInvoices() == null) {
            ArrayOfInvoice array = new ArrayOfInvoice();
            return array.getInvoice();
        } else {
            return responseObj.getInvoices().getInvoice();
        }
    }

    @Deprecated
    // deprecated as of version 1.0.0 - maintained for backwards compatibility
    public List<Invoice> getInvoices(Date modifiedAfter, String where, String order, String page, String unitdp,String ids)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);
        addToMapIfNotNull(params, "Ids", ids);
        addToMapIfNotNull(params, "unitdp", unitdp);

        Response responseObj = get("Invoices", modifiedAfter, params);
        if (responseObj.getInvoices() == null) {
            ArrayOfInvoice array = new ArrayOfInvoice();
            return array.getInvoice();
        } else {
            return responseObj.getInvoices().getInvoice();
        }
    }

    public List<Invoice> createInvoices(List<Invoice> invoices) throws IOException {
        ArrayOfInvoice array = new ArrayOfInvoice();
        array.getInvoice().addAll(invoices);
        return put("Invoices", objFactory.createInvoices(array)).getInvoices().getInvoice();
    }

    public List<Invoice> createInvoices(List<Invoice> invoices, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfInvoice array = new ArrayOfInvoice();
        array.getInvoice().addAll(invoices);
        return put("Invoices", objFactory.createInvoices(array), params).getInvoices().getInvoice();
    }
    
    public List<Invoice> createInvoices(List<Invoice> invoices, String unitdp,Boolean summarizeErrors) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);
        addToMapIfNotNull(params, "SummarizeErrors", summarizeErrors);

        ArrayOfInvoice array = new ArrayOfInvoice();
        array.getInvoice().addAll(invoices);
        return put("Invoices", objFactory.createInvoices(array), params).getInvoices().getInvoice();
    }

    public List<Invoice> updateInvoice(List<Invoice> objects) throws IOException {
        ArrayOfInvoice array = new ArrayOfInvoice();
        array.getInvoice().addAll(objects);
        return post("Invoices", objFactory.createInvoices(array)).getInvoices().getInvoice();
    }

    public List<Invoice> updateInvoice(List<Invoice> objects, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfInvoice array = new ArrayOfInvoice();
        array.getInvoice().addAll(objects);
        return post("Invoices", objFactory.createInvoices(array), params).getInvoices().getInvoice();
    }

    public Invoice getInvoice(String id) throws IOException {
        return singleResult(get("Invoices/" + id).getInvoices().getInvoice());
    }

    public Invoice getInvoice(String id, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);
        return singleResult(get("Invoices/" + id, null, params).getInvoices().getInvoice());
    }
    
    @Deprecated
    public String getInvoicePdf(String id, String dirPath) throws IOException {
        return getFile("Invoices/" + id, null, null, "application/pdf", dirPath);
    }
    
    public ByteArrayInputStream getInvoicePdfContent(String id) throws IOException {
        return getInputStream("Invoices/" + id, null, null, "application/pdf");
    }

    public OnlineInvoice getOnlineInvoice(String id) throws IOException {
        return singleResult(get("Invoices/" + id + "/OnlineInvoice").getOnlineInvoices().getOnlineInvoice());
    }

    // INVOICE REMINDER
    public List<InvoiceReminder> getInvoiceReminders() throws IOException {
        Response responseObj = get("InvoiceReminders/Settings");
        if (responseObj.getInvoiceReminders() == null) {
            ArrayOfInvoiceReminder array = new ArrayOfInvoiceReminder();
            return array.getInvoiceReminder();
        } else {
            return responseObj.getInvoiceReminders().getInvoiceReminder();
        }
    }

    //ITEMS
    public List<Item> getItems() throws IOException {
        Response responseObj = get("Items");
        if (responseObj.getItems() == null) {
            ArrayOfItem array = new ArrayOfItem();
            return array.getItem();
        } else {
            return responseObj.getItems().getItem();
        }
    }

    public List<Item> getItems(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Items", modifiedAfter, params);
        if (responseObj.getItems() == null) {
            ArrayOfItem array = new ArrayOfItem();
            return array.getItem();
        } else {
            return responseObj.getItems().getItem();
        }
    }

    public List<Item> getItems(Date modifiedAfter, String where, String order, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "unitdp", unitdp);

        Response responseObj = get("Items", modifiedAfter, params);
        if (responseObj.getItems() == null) {
            ArrayOfItem array = new ArrayOfItem();
            return array.getItem();
        } else {
            return responseObj.getItems().getItem();
        }
    }

    public List<Item> createItems(List<Item> objects) throws IOException {
        ArrayOfItem array = new ArrayOfItem();
        array.getItem().addAll(objects);
        return put("Items", objFactory.createItems(array)).getItems().getItem();
    }

    public List<Item> createItems(List<Item> objects, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfItem array = new ArrayOfItem();
        array.getItem().addAll(objects);
        return put("Items", objFactory.createItems(array), params).getItems().getItem();
    }

    public List<Item> updateItem(List<Item> objects) throws IOException {
        ArrayOfItem array = new ArrayOfItem();
        array.getItem().addAll(objects);
        return post("Items", objFactory.createItems(array)).getItems().getItem();
    }

    public List<Item> updateItem(List<Item> objects, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfItem array = new ArrayOfItem();
        array.getItem().addAll(objects);
        return post("Items", objFactory.createItems(array), params).getItems().getItem();
    }

    public Item getItem(String id) throws IOException {
        return singleResult(get("Items/" + id).getItems().getItem());
    }

    public Item getItem(String id, String unitdp) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);
        return singleResult(get("Items/" + id, null, params).getItems().getItem());
    }

    public String deleteItem(String id) throws IOException {
        return delete("Items/" + id).getStatus();
    }

    // JOURNALS
    public List<Journal> getJournals() throws IOException {
        Response responseObj = get("Journals");
        if (responseObj.getJournals() == null) {
            ArrayOfJournal array = new ArrayOfJournal();
            return array.getJournal();
        } else {
            return responseObj.getJournals().getJournal();
        }
    }

    public List<Journal> getJournals(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Journals", modifiedAfter, params);
        if (responseObj.getJournals() == null) {
            ArrayOfJournal array = new ArrayOfJournal();
            return array.getJournal();
        } else {
            return responseObj.getJournals().getJournal();
        }
    }

    public List<Journal> getJournals(Date modifiedAfter, String offset, boolean paymentsOnly) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "offset", offset);
        addToMapIfNotNull(params, "paymentsOnly", paymentsOnly);

        Response responseObj = get("Journals", modifiedAfter, params);
        if (responseObj.getJournals() == null) {
            ArrayOfJournal array = new ArrayOfJournal();
            return array.getJournal();
        } else {
            return responseObj.getJournals().getJournal();
        }
    }

    public Journal getJournal(String id) throws IOException {
        return singleResult(get("Journals/" + id).getJournals().getJournal());
    }

    //LINKED TRANSACTIONS
    public List<LinkedTransaction> getLinkedTransactions() throws IOException {
        Response responseObj = get("LinkedTransactions");
        if (responseObj.getLinkedTransactions() == null) {
            ArrayOfLinkedTransaction array = new ArrayOfLinkedTransaction();
            return array.getLinkedTransaction();
        } else {
            return responseObj.getLinkedTransactions().getLinkedTransaction();
        }
    }

    public List<LinkedTransaction> getLinkedTransactions(Date modifiedAfter, String where, String order)
        throws IOException {
        return getLinkedTransactions(modifiedAfter, where, order, null);
    }

    public List<LinkedTransaction> getLinkedTransactions(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("LinkedTransactions", modifiedAfter, params);
        if (responseObj.getLinkedTransactions() == null) {
            ArrayOfLinkedTransaction array = new ArrayOfLinkedTransaction();
            return array.getLinkedTransaction();
        } else {
            return responseObj.getLinkedTransactions().getLinkedTransaction();
        }
    }

    public List<LinkedTransaction> createLinkedTransactions(List<LinkedTransaction> objects) throws IOException {
        ArrayOfLinkedTransaction array = new ArrayOfLinkedTransaction();
        array.getLinkedTransaction().addAll(objects);
        return put("LinkedTransactions", objFactory.createLinkedTransactions(array))
            .getLinkedTransactions()
            .getLinkedTransaction();
    }

    public List<LinkedTransaction> updateLinkedTransaction(List<LinkedTransaction> objects) throws IOException {
        ArrayOfLinkedTransaction array = new ArrayOfLinkedTransaction();
        array.getLinkedTransaction().addAll(objects);
        return post("LinkedTransactions", objFactory.createLinkedTransactions(array))
            .getLinkedTransactions()
            .getLinkedTransaction();
    }

    public LinkedTransaction getLinkedTransaction(String id) throws IOException {
        return singleResult(get("LinkedTransactions/" + id).getLinkedTransactions().getLinkedTransaction());
    }

    public String deleteLinkedTransaction(String id) throws IOException {
        return delete("LinkedTransactions/" + id).getStatus();
    }

    //ManualJournals
    public List<ManualJournal> getManualJournals() throws IOException {
        Response responseObj = get("ManualJournal");
        if (responseObj.getManualJournals() == null) {
            ArrayOfManualJournal array = new ArrayOfManualJournal();
            return array.getManualJournal();
        } else {
            return responseObj.getManualJournals().getManualJournal();
        }
    }

    public List<ManualJournal> getManualJournals(Date modifiedAfter, String where, String order) throws IOException {
        return getManualJournals(modifiedAfter, where, order, null);
    }

    public List<ManualJournal> getManualJournals(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("ManualJournals", modifiedAfter, params);
        if (responseObj.getManualJournals() == null) {
            ArrayOfManualJournal array = new ArrayOfManualJournal();
            return array.getManualJournal();
        } else {
            return responseObj.getManualJournals().getManualJournal();
        }
    }

    public List<ManualJournal> createManualJournals(List<ManualJournal> objects) throws IOException {
        ArrayOfManualJournal array = new ArrayOfManualJournal();
        array.getManualJournal().addAll(objects);
        return put("ManualJournal", objFactory.createManualjournals(array)).getManualJournals().getManualJournal();
    }

    public List<ManualJournal> updateManualJournal(List<ManualJournal> objects) throws IOException {
        ArrayOfManualJournal array = new ArrayOfManualJournal();
        array.getManualJournal().addAll(objects);
        return post("ManualJournals", objFactory.createManualjournals(array)).getManualJournals().getManualJournal();
    }

    public ManualJournal getManualJournal(String id) throws IOException {
        return singleResult(get("ManualJournals/" + id).getManualJournals().getManualJournal());
    }

    //ORGANIZATION
    public List<Organisation> getOrganisations() throws IOException {
        return get("Organisations").getOrganisations().getOrganisation();
    }

    //OVERPAYMENTS
    public List<Overpayment> getOverpayments() throws IOException {
        Response responseObj = get("Overpayments");
        if (responseObj.getOverpayments() == null) {
            ArrayOfOverpayment array = new ArrayOfOverpayment();
            return array.getOverpayment();
        } else {
            return responseObj.getOverpayments().getOverpayment();
        }
    }

    public List<Overpayment> getOverpayments(Date modifiedAfter, String where, String order) throws IOException {
        return getOverpayments(modifiedAfter, where, order, null);
    }

    public List<Overpayment> getOverpayments(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("Overpayments", modifiedAfter, params);
        if (responseObj.getOverpayments() == null) {
            ArrayOfOverpayment array = new ArrayOfOverpayment();
            return array.getOverpayment();
        } else {
            return responseObj.getOverpayments().getOverpayment();
        }
    }

    public List<Allocation> createOverpaymentAllocations(List<Allocation> objects, String id) throws IOException {
        ArrayOfAllocation array = new ArrayOfAllocation();
        array.getAllocation().addAll(objects);
        return put("Overpayments/" + id + "/Allocations", objFactory.createAllocations(array))
            .getAllocations()
            .getAllocation();
    }

    public Overpayment getOverpayment(String id) throws IOException {
        return singleResult(get("Overpayments/" + id).getOverpayments().getOverpayment());
    }

    //PAYMENTS
    public List<Payment> getPayments() throws IOException {
        Response responseObj = get("Payments");
        if (responseObj.getPayments() == null) {
            ArrayOfPayment array = new ArrayOfPayment();
            return array.getPayment();
        } else {
            return responseObj.getPayments().getPayment();
        }
    }

    public List<Payment> getPayments(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Payments", modifiedAfter, params);
        if (responseObj.getPayments() == null) {
            ArrayOfPayment array = new ArrayOfPayment();
            return array.getPayment();
        } else {
            return responseObj.getPayments().getPayment();
        }
    }

    public List<Payment> createPayments(List<Payment> objects) throws IOException {
        ArrayOfPayment array = new ArrayOfPayment();
        array.getPayment().addAll(objects);
        return put("Payments", objFactory.createPayments(array)).getPayments().getPayment();
    }

    public List<Payment> deletePayment(Payment object) throws IOException {
        Payment payment = new Payment();
        payment.setStatus(PaymentStatus.DELETED);

        return post("Payments/" + object.getPaymentID(), objFactory.createPayment(payment)).getPayments().getPayment();
    }

    public List<Payment> deletePayment(List<Payment> objects) throws IOException {
        ArrayOfPayment array = new ArrayOfPayment();
        array.getPayment().addAll(objects);
        return post("Payments", objFactory.createPayments(array)).getPayments().getPayment();
    }

    public Payment getPayment(String id) throws IOException {
        return singleResult(get("Payments/" + id).getPayments().getPayment());
    }

    //PREPAYMENTS
    public List<Prepayment> getPrepayments() throws IOException {
        Response responseObj = get("Prepayments");
        if (responseObj.getPrepayments() == null) {
            ArrayOfPrepayment array = new ArrayOfPrepayment();
            return array.getPrepayment();
        } else {
            return responseObj.getPrepayments().getPrepayment();
        }
    }

    public List<Prepayment> getPrepayments(Date modifiedAfter, String where, String order) throws IOException {
        return getPrepayments(modifiedAfter, where, order, null);
    }

    public List<Prepayment> getPrepayments(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("Prepayments", modifiedAfter, params);
        if (responseObj.getPrepayments() == null) {
            ArrayOfPrepayment array = new ArrayOfPrepayment();
            return array.getPrepayment();
        } else {
            return responseObj.getPrepayments().getPrepayment();
        }
    }

    public List<Allocation> createPrepaymentAllocations(List<Allocation> objects, String id) throws IOException {
        ArrayOfAllocation array = new ArrayOfAllocation();
        array.getAllocation().addAll(objects);
        return put("Prepayments/" + id + "/Allocations", objFactory.createAllocations(array))
            .getAllocations()
            .getAllocation();
    }

    public Prepayment getPrepayment(String id) throws IOException {
        return singleResult(get("Prepayments/" + id).getPrepayments().getPrepayment());
    }

    //PURCHASE ORDERS
    public List<PurchaseOrder> getPurchaseOrders() throws IOException {
        Response responseObj = get("PurchaseOrders");
        if (responseObj.getPurchaseOrders() == null) {
            ArrayOfPurchaseOrder array = new ArrayOfPurchaseOrder();
            return array.getPurchaseOrder();
        } else {
            return responseObj.getPurchaseOrders().getPurchaseOrder();
        }
    }

    public List<PurchaseOrder> getPurchaseOrders(Date modifiedAfter, String where, String order) throws IOException {
        return getPurchaseOrders(modifiedAfter, where, order, null);
    }

    public List<PurchaseOrder> getPurchaseOrders(Date modifiedAfter, String where, String order, String page)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "page", page);

        Response responseObj = get("PurchaseOrders", modifiedAfter, params);
        if (responseObj.getPurchaseOrders() == null) {
            ArrayOfPurchaseOrder array = new ArrayOfPurchaseOrder();
            return array.getPurchaseOrder();
        } else {
            return responseObj.getPurchaseOrders().getPurchaseOrder();
        }
    }

    public List<PurchaseOrder> createPurchaseOrders(List<PurchaseOrder> objects) throws IOException {
        ArrayOfPurchaseOrder array = new ArrayOfPurchaseOrder();
        array.getPurchaseOrder().addAll(objects);
        return put("PurchaseOrders", objFactory.createPurchaseOrders(array)).getPurchaseOrders().getPurchaseOrder();
    }

    public List<PurchaseOrder> updatePurchaseOrder(List<PurchaseOrder> objects) throws IOException {
        ArrayOfPurchaseOrder array = new ArrayOfPurchaseOrder();
        array.getPurchaseOrder().addAll(objects);
        return post("PurchaseOrders", objFactory.createPurchaseOrders(array)).getPurchaseOrders().getPurchaseOrder();
    }

    public PurchaseOrder getPurchaseOrder(String id) throws IOException {
        return singleResult(get("PurchaseOrders/" + id).getPurchaseOrders().getPurchaseOrder());
    }
    
    @Deprecated
    public String getPurchaseOrderPdf(String id, String dirPath) throws IOException {
        return getFile("PurchaseOrders/" + id, null, null, "application/pdf", dirPath);
    }
    
    public ByteArrayInputStream getPurchaseOrderPdfContent(String id) throws IOException {
        return getInputStream("PurchaseOrders/" + id, null, null, "application/pdf");
    }

    //RECEIPTS
    public List<Receipt> getReceipts() throws IOException {
        Response responseObj = get("Receipts");
        if (responseObj.getReceipts() == null) {
            ArrayOfReceipt array = new ArrayOfReceipt();
            return array.getReceipt();
        } else {
            return responseObj.getReceipts().getReceipt();
        }
    }

    public List<Receipt> getReceipts(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Receipts", modifiedAfter, params);
        if (responseObj.getReceipts() == null) {
            ArrayOfReceipt array = new ArrayOfReceipt();
            return array.getReceipt();
        } else {
            return responseObj.getReceipts().getReceipt();
        }
    }

    public List<Receipt> createReceipts(List<Receipt> objects) throws IOException {
        ArrayOfReceipt array = new ArrayOfReceipt();
        array.getReceipt().addAll(objects);
        return put("Receipts", objFactory.createReceipts(array)).getReceipts().getReceipt();
    }
    
    public List<Receipt> createReceipts(List<Receipt> objects, String unitdp) throws IOException {        
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "unitdp", unitdp);

        ArrayOfReceipt array = new ArrayOfReceipt();
        array.getReceipt().addAll(objects);
        return put("Receipts", objFactory.createReceipts(array),params).getReceipts().getReceipt();
    }
  
    public List<Receipt> updateReceipt(List<Receipt> objects) throws IOException {
        ArrayOfReceipt array = new ArrayOfReceipt();
        array.getReceipt().addAll(objects);
        return post("Receipts", objFactory.createReceipts(array)).getReceipts().getReceipt();
    }

    public Receipt getReceipt(String id) throws IOException {
        return singleResult(get("Receipts/" + id).getReceipts().getReceipt());
    }

    //REPEATING INVOICES
    public List<RepeatingInvoice> getRepeatingInvoices() throws IOException {
        Response responseObj = get("RepeatingInvoices");
        if (responseObj.getRepeatingInvoices() == null) {
            ArrayOfRepeatingInvoice array = new ArrayOfRepeatingInvoice();
            return array.getRepeatingInvoice();
        } else {
            return responseObj.getRepeatingInvoices().getRepeatingInvoice();
        }
        //return get("RepeatingInvoices").getRepeatingInvoices().getRepeatingInvoice();
    }

    public List<RepeatingInvoice> getRepeatingInvoices(Date modifiedAfter, String where, String order)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("RepeatingInvoices", modifiedAfter, params);
        if (responseObj.getRepeatingInvoices() == null) {
            ArrayOfRepeatingInvoice array = new ArrayOfRepeatingInvoice();
            return array.getRepeatingInvoice();
        } else {
            return responseObj.getRepeatingInvoices().getRepeatingInvoice();
        }
    }

    public RepeatingInvoice getRepeatingInvoice(String id) throws IOException {
        return singleResult(get("RepeatingInvoices/" + id).getRepeatingInvoices().getRepeatingInvoice());
    }

    //REPORTS
    public Report getReport(String id, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        return singleResult(get("reports/" + id, null, params).getReports().getReport());
    }

    public Report getReportAgedPayablesByContact(String contactId,
                                                 String where,
                                                 String order,
                                                 String date,
                                                 String fromDate,
                                                 String toDate) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "contactID", contactId);
        addToMapIfNotNull(params, "date", date);
        addToMapIfNotNull(params, "fromDate", fromDate);
        addToMapIfNotNull(params, "toDate", toDate);
        return singleResult(get("reports/AgedPayablesByContact", null, params).getReports().getReport());
    }

    public Report getReportAgedReceivablesByContact(String contactId,
                                                    String where,
                                                    String order,
                                                    String date,
                                                    String fromDate,
                                                    String toDate) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "contactID", contactId);
        addToMapIfNotNull(params, "date", date);
        addToMapIfNotNull(params, "fromDate", fromDate);
        addToMapIfNotNull(params, "toDate", toDate);
        return singleResult(get("reports/AgedReceivablesByContact", null, params).getReports().getReport());
    }

    public Report getReportBalanceSheet(String where,
                                        String order,
                                        String date,
                                        String trackingOptionId1,
                                        String trackingOptionId2,
                                        boolean standardLayout,
                                        boolean paymentsOnly,
                                        Integer periods,
                                        String timeframe) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "date", date);
        addToMapIfNotNull(params, "trackingOptionID1", trackingOptionId1);
        addToMapIfNotNull(params, "trackingOptionID2", trackingOptionId2);
        addToMapIfNotNull(params, "standardLayout", standardLayout);
        addToMapIfNotNull(params, "paymentsOnly", paymentsOnly);
        addToMapIfNotNull(params, "periods", periods);
        addToMapIfNotNull(params, "timeframe", timeframe);
        return singleResult(get("reports/BalanceSheet", null, params).getReports().getReport());
    }

    public Report getReportBalanceSheet(String where,
                                        String order,
                                        String date,
                                        String trackingOptionId1,
                                        String trackingOptionId2,
                                        boolean standardLayout,
                                        boolean paymentsOnly) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "date", date);
        addToMapIfNotNull(params, "trackingOptionID1", trackingOptionId1);
        addToMapIfNotNull(params, "trackingOptionID2", trackingOptionId2);
        addToMapIfNotNull(params, "standardLayout", standardLayout);
        addToMapIfNotNull(params, "paymentsOnly", paymentsOnly);
        return singleResult(get("reports/BalanceSheet", null, params).getReports().getReport());
    }


    public Report getReportBankStatement(String accountId, String where, String order, String fromDate, String toDate)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "bankAccountID", accountId);
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "fromDate", fromDate);
        addToMapIfNotNull(params, "toDate", toDate);
        return singleResult(get("reports/BankStatement", null, params).getReports().getReport());
    }

    public Report getReportBudgetSummary(String where, String order, String date, Integer periods, Integer timeframe)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "date", date);
        addToMapIfNotNull(params, "timeframe", timeframe);
        addToMapIfNotNull(params, "periods", periods);
        return singleResult(get("reports/BudgetSummary", null, params).getReports().getReport());
    }

    public Report getExecutiveSummary(String where, String order, String date) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "date", date);
        return singleResult(get("reports/ExecutiveSummary", null, params).getReports().getReport());
    }

    public Report getReportProfitLoss(String where,
                                      String order,
                                      String fromDate,
                                      String toDate,
                                      String trackingCategoryId,
                                      String trackingOptionId1,
                                      String trackingCategoryId2,
                                      String trackingOptionId2,
                                      boolean standardLayout,
                                      boolean paymentsOnly) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "fromDate", fromDate);
        addToMapIfNotNull(params, "toDate", toDate);
        addToMapIfNotNull(params, "trackingCategoryID", trackingCategoryId);
        addToMapIfNotNull(params, "trackingOptionID1", trackingOptionId1);
        addToMapIfNotNull(params, "trackingCategoryID2", trackingCategoryId2);
        addToMapIfNotNull(params, "trackingOptionID2", trackingOptionId2);
        addToMapIfNotNull(params, "standardLayout", standardLayout);
        addToMapIfNotNull(params, "paymentsOnly", paymentsOnly);
        return singleResult(get("reports/ProfitAndLoss", null, params).getReports().getReport());
    }

    public Report getReportProfitLoss(String where,
                                      String order,
                                      String fromDate,
                                      String toDate,
                                      String trackingCategoryId,
                                      String trackingOptionId1,
                                      String trackingCategoryId2,
                                      String trackingOptionId2,
                                      boolean standardLayout,
                                      boolean paymentsOnly,
                                      Integer periods,
                                      String timeframe) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "fromDate", fromDate);
        addToMapIfNotNull(params, "toDate", toDate);
        addToMapIfNotNull(params, "trackingCategoryID", trackingCategoryId);
        addToMapIfNotNull(params, "trackingOptionID1", trackingOptionId1);
        addToMapIfNotNull(params, "trackingCategoryID2", trackingCategoryId2);
        addToMapIfNotNull(params, "trackingOptionID2", trackingOptionId2);
        addToMapIfNotNull(params, "standardLayout", standardLayout);
        addToMapIfNotNull(params, "paymentsOnly", paymentsOnly);
        addToMapIfNotNull(params, "periods", periods);
        addToMapIfNotNull(params, "timeframe", timeframe);
        return singleResult(get("reports/ProfitAndLoss", null, params).getReports().getReport());
    }

    public Report getReportTrialBalance(String date, boolean paymentsOnly) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "date", date);
        addToMapIfNotNull(params, "paymentsOnly", paymentsOnly);

        return singleResult(this.get("reports/TrialBalance", null, params).getReports().getReport());
    }

    //TAX RATES
    public List<TaxRate> getTaxRates() throws IOException {
        Response responseObj = get("TaxRates");
        if (responseObj.getTaxRates() == null) {
            ArrayOfTaxRate array = new ArrayOfTaxRate();
            return array.getTaxRate();
        } else {
            return responseObj.getTaxRates().getTaxRate();
        }
    }

    public List<TaxRate> getTaxRates(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("TaxRates", modifiedAfter, params);
        if (responseObj.getTaxRates() == null) {
            ArrayOfTaxRate array = new ArrayOfTaxRate();
            return array.getTaxRate();
        } else {
            return responseObj.getTaxRates().getTaxRate();
        }
    }

    public List<TaxRate> createTaxRates(List<TaxRate> objects) throws IOException {
        ArrayOfTaxRate array = new ArrayOfTaxRate();
        array.getTaxRate().addAll(objects);
        return put("TaxRates", objFactory.createTaxRates(array)).getTaxRates().getTaxRate();
    }

    public List<TaxRate> updateTaxRate(List<TaxRate> objects) throws IOException {
        ArrayOfTaxRate array = new ArrayOfTaxRate();
        array.getTaxRate().addAll(objects);
        return post("TaxRates", objFactory.createTaxRates(array)).getTaxRates().getTaxRate();
    }

    public TaxRate getTaxRate(String id) throws IOException {
        return singleResult(get("TaxRates/" + id).getTaxRates().getTaxRate());
    }

    //TRACKING CATEGORIES
    public List<TrackingCategory> getTrackingCategories() throws IOException {
        Response responseObj = get("TrackingCategories");
        if (responseObj.getTrackingCategories() == null) {
            ArrayOfTrackingCategory array = new ArrayOfTrackingCategory();
            return array.getTrackingCategory();
        } else {
            return responseObj.getTrackingCategories().getTrackingCategory();
        }
    }

    public List<TrackingCategory> getTrackingCategories(Date modifiedAfter, String where, String order,
                                                        Boolean includeArchived)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);
        addToMapIfNotNull(params, "includeArchived", includeArchived);

        Response responseObj = get("TrackingCategories", modifiedAfter, params);
        if (responseObj.getTrackingCategories() == null) {
            ArrayOfTrackingCategory array = new ArrayOfTrackingCategory();
            return array.getTrackingCategory();
        } else {
            return responseObj.getTrackingCategories().getTrackingCategory();
        }
    }

    public List<TrackingCategory> createTrackingCategories(List<TrackingCategory> objects) throws IOException {
        ArrayOfTrackingCategory array = new ArrayOfTrackingCategory();
        array.getTrackingCategory().addAll(objects);
        return put("TrackingCategories", objFactory.createTrackingCategories(array))
            .getTrackingCategories()
            .getTrackingCategory();
    }

    public List<TrackingCategory> createTrackingCategories(List<TrackingCategory> objects, boolean summarizeErrors)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "summarizeErrors", summarizeErrors);

        ArrayOfTrackingCategory array = new ArrayOfTrackingCategory();
        array.getTrackingCategory().addAll(objects);
        return put("TrackingCategories", objFactory.createTrackingCategories(array), params)
            .getTrackingCategories()
            .getTrackingCategory();
    }

    public List<TrackingCategory> updateTrackingCategory(List<TrackingCategory> objects) throws IOException {
        ArrayOfTrackingCategory array = new ArrayOfTrackingCategory();
        array.getTrackingCategory().addAll(objects);
        return post("TrackingCategories", objFactory.createTrackingCategories(array))
            .getTrackingCategories()
            .getTrackingCategory();
    }

    public List<TrackingCategory> updateTrackingCategory(List<TrackingCategory> objects, boolean summarizeErrors)
        throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "summarizeErrors", summarizeErrors);

        ArrayOfTrackingCategory array = new ArrayOfTrackingCategory();
        array.getTrackingCategory().addAll(objects);
        return post("TrackingCategories", objFactory.createTrackingCategories(array))
            .getTrackingCategories()
            .getTrackingCategory();
    }

    public TrackingCategory getTrackingCategory(String id) throws IOException {
        return singleResult(get("TrackingCategories/" + id).getTrackingCategories().getTrackingCategory());
    }

    public String deleteTrackingCategory(String id) throws IOException {
        return delete("TrackingCategories/" + id).getStatus();
    }

    // TRACK CATEGORY OPTIONS
    public List<TrackingCategoryOption> createTrackingCategoryOption(List<TrackingCategoryOption> objects, String id)
        throws IOException {
        ArrayOfTrackingCategoryOption array = new ArrayOfTrackingCategoryOption();
        array.getOption().addAll(objects);
        return put("TrackingCategories/" + id + "/Options", objFactory.createTrackingCategoryOptions(array))
            .getOptions()
            .getOption();
    }

    public List<TrackingCategoryOption> createTrackingCategoryOption(List<TrackingCategoryOption> objects,
                                                                     String id,
                                                                     boolean summarizeErrors) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "summarizeErrors", summarizeErrors);
        System.out.println("SIZE " + objects.size());

        ArrayOfTrackingCategoryOption array = new ArrayOfTrackingCategoryOption();
        array.getOption().addAll(objects);
        return put("TrackingCategories/" + id + "/Options", objFactory.createTrackingCategoryOptions(array), params)
            .getOptions()
            .getOption();
    }

    public TrackingCategoryOption updateTrackingCategoryOption(TrackingCategoryOption object,
                                                               String TrackingCategoryID,
                                                               String TrackingOptionID) throws IOException {
        ArrayOfTrackingCategoryOption array = new ArrayOfTrackingCategoryOption();
        array.getOption().add(object);
        return post("TrackingCategories/" + TrackingCategoryID + "/Options/" + TrackingOptionID,
            objFactory.createTrackingCategoryOptions(array)).getOptions().getOption().get(0);
    }

    public TrackingCategoryOption updateTrackingCategoryOption(TrackingCategoryOption object,
                                                               String TrackingCategoryID,
                                                               String TrackingOptionID,
                                                               boolean summarizeErrors) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "summarizeErrors", summarizeErrors);

        ArrayOfTrackingCategoryOption array = new ArrayOfTrackingCategoryOption();
        array.getOption().add(object);
        return post("TrackingCategories/" + TrackingCategoryID + "/Options/" + TrackingOptionID,
            objFactory.createTrackingCategoryOptions(array)).getOptions().getOption().get(0);
    }

    public String deleteTrackingCategoryOption(String TrackingCategoryID, String TrackingOptionID) throws IOException {
        return delete("TrackingCategories/" + TrackingCategoryID + "/Options/" + TrackingOptionID).getStatus();
    }

    // USERS
    public List<User> getUsers() throws IOException {
        Response responseObj = get("Users");
        if (responseObj.getUsers() == null) {
            ArrayOfUser array = new ArrayOfUser();
            return array.getUser();
        } else {
            return responseObj.getUsers().getUser();
        }
    }

    public List<User> getUsers(Date modifiedAfter, String where, String order) throws IOException {
        Map<String, String> params = new HashMap<>();
        addToMapIfNotNull(params, "Where", where);
        addToMapIfNotNull(params, "order", order);

        Response responseObj = get("Users", modifiedAfter, params);
        if (responseObj.getUsers() == null) {
            ArrayOfUser array = new ArrayOfUser();
            return array.getUser();
        } else {
            return responseObj.getUsers().getUser();
        }
    }

    public User getUser(String id) throws IOException {
        return singleResult(get("Users/" + id).getUsers().getUser());
    }

    // ATTACHMENTS
    public List<Attachment> getAttachments(String endpoint, String guid) throws IOException {
        return get(endpoint + "/" + guid + "/Attachments/", null, null).getAttachments().getAttachment();
    }
    
    public Attachment createAttachment(String endpoint, String guid, String filename, String contentType, byte[] bytes)
            throws IOException {
    		return createAttachment(endpoint, guid, filename, contentType, bytes, false);
    }

    public Attachment createAttachment(
        final String endpoint,
        final String guid,
        final String filename,
        final String contentType,
        final byte[] bytes,
        final boolean includeOnline) throws IOException {

        requireNonNull(endpoint, "endpoint must not be null");
        requireNonNull(guid, "guid must not be null");
        requireNonNull(filename, "filename must not be null");
        requireNonNull(contentType, "contentType must not be null");
        requireNonNull(bytes, "bytes must not be null");

        final HashMap<String, String> params = new HashMap();
        if (includeOnline) {
            params.put("IncludeOnline",  Boolean.toString(true));
        }

        final String alphaNumericFileName = normalizeFileNameForURI(filename);
        return singleResult(
            put(
                format("%s/%s/Attachments/%s",endpoint, guid, alphaNumericFileName),
                contentType,
                bytes,
                params
            ).getAttachments().getAttachment());
    }


    /**
     * Normalizes file name with respect to https://tools.ietf.org/html/rfc3986#section-2.3
     *
     * @param fileName
     * @return file name which does not contain invalid URI characters
     */
    protected String normalizeFileNameForURI(final String fileName) {
        return fileName
            .trim()
            .replaceAll(" ", "_")
            .replaceAll("[^\\p{Alnum}\\-_.~]", "");
    }


    public String getAttachmentContent(String endpoint, String guid, String filename, String accept, String dirPath)
        throws IOException {
        String encodedFileName = URLEncoder.encode(filename, "UTF-8").replace("+", "%20");
        return getFile(endpoint + "/" + guid + "/Attachments/" + encodedFileName, null, null, accept, dirPath);
    }

    public ByteArrayInputStream getAttachmentContent(String endpoint, String guid, String filename, String accept)
        throws IOException {
        String encodedFileName = URLEncoder.encode(filename, "UTF-8").replace("+", "%20");
        return getInputStream(endpoint + "/" + guid + "/Attachments/" + encodedFileName, null, null, accept);
    }
}
