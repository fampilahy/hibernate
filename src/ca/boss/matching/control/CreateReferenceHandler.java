package ca.boss.matching.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import ca.boss.matching.model.bean.Reference;
//import ca.boss.matching.model.dao.DaoFactory;
import ca.boss.matching.model.dao.ReferenceDao;
import ca.boss.matching.model.dao.ReferenceDaoImplementation;

public class CreateReferenceHandler {

	private static final String BRAND_KEY = "brand";
	private static final String MODEL_KEY = "model";
	private static final String TITLE_KEY = "title";
	private static final String EAN_KEY = "ean";
	private static final String COLOR_KEY = "color";
	private static final String SIZE_KEY = "size";
	private static final String CAPACITY_KEY = "capacity";
	private static final String MEMORY_KEY = "memory";
	private static final String DESCRIPTION_KEY = "description";
	private static final String PRICE_KEY = "price";
	private static final String URL_KEY = "url";
	private static final String IMAGE_KEY = "image";

	private ReferenceDaoImplementation referenceDaoImplementation = null;

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	private Map<String, String> errors = null;
	private String message = null;
	private Reference reference = null;

	public static CreateReferenceHandler getDefault(ReferenceDaoImplementation referenceDaoImplementation) {
		return new CreateReferenceHandler(referenceDaoImplementation);
	}

	private CreateReferenceHandler(ReferenceDaoImplementation referenceDaoImplementation) {
		this.referenceDaoImplementation = referenceDaoImplementation;
	}

	public void validateForm(HttpServletRequest request) {

		String brand = null, model = null, title = null, url = null, image = null;
		String ean = null, color = null, size = null, capacity = null, memory = null, description = null;
		Float fPrice = null;
		// image1, image2, image3, image4; next dev

		try {
			brand = getValue(request, BRAND_KEY, true);
		} catch (Exception e) {
			putError(BRAND_KEY, e.getMessage());
		}

		try {
			model = getValue(request, MODEL_KEY, true);
		} catch (Exception e) {
			putError(MODEL_KEY, e.getMessage());
		}

		try {
			title = getValue(request, TITLE_KEY, true);
		} catch (Exception e) {
			putError(TITLE_KEY, e.getMessage());
		}

		try {
			ean = getValue(request, EAN_KEY, false);
		} catch (Exception e) {
			putError(EAN_KEY, e.getMessage());
		}

		try {
			color = getValue(request, COLOR_KEY, false);
		} catch (Exception e) {
			putError(COLOR_KEY, e.getMessage());
		}

		try {
			size = getValue(request, SIZE_KEY, false);
		} catch (Exception e) {
			putError(SIZE_KEY, e.getMessage());
		}

		try {
			capacity = getValue(request, CAPACITY_KEY, false);
		} catch (Exception e) {
			putError(CAPACITY_KEY, e.getMessage());
		}

		try {
			memory = getValue(request, MEMORY_KEY, false);
		} catch (Exception e) {
			putError(MEMORY_KEY, e.getMessage());
		}

		try {
			description = getValue(request, DESCRIPTION_KEY, false);
		} catch (Exception e) {
			putError(DESCRIPTION_KEY, e.getMessage());
		}

		try {
			fPrice = parseFloat(getValue(request, PRICE_KEY, false));
		} catch (Exception e) {
			putError(PRICE_KEY, e.getMessage());
		}

		try {
			url = getValue(request, URL_KEY, true);
		} catch (Exception e) {
			putError(URL_KEY, e.getMessage());
		}

		try {
			image = getValue(request, IMAGE_KEY, true);
		} catch (Exception e) {
			putError(IMAGE_KEY, e.getMessage());
		}

		// price error not blocking
		if (errors == null || errors.isEmpty() || (errors.size() == 1 && errors.containsKey(PRICE_KEY))) {
			reference = new Reference();
			reference.setBrand(brand);
			reference.setModel(model);
			reference.setTitle(title);
			reference.setUrl(url);
			reference.setImage(image);
			// reference.setEan(ean);
			// reference.setColor(color);
			// reference.setSize(size);
			// reference.setCapacity(capacity);
			// reference.setMemory(memory);
			// reference.setDescription(description);
			// reference.setPrice(fPrice);

			ReferenceDao referenceDao;

			try {
				// referenceDao = referenceDaoImplementation.
				referenceDaoImplementation.creer(reference);
				// referenceDao.createReference(reference);
				message = "reference created - ";
			} catch (Exception e) {
				putError("daoerror", "" + e.getMessage());
				message = "error from dao - ";
			}
		} else
			message = "reference not created - ";
	}

	private Float parseFloat(String price) throws CreateReferenceException {
		price = price.replace(",", ".");
		price = price.replaceAll("[^\\d.]", "");
		Float fPrice = null;
		try {
			fPrice = Float.parseFloat(price);
		} catch (Exception e) {
			throw new CreateReferenceException("non parsable price value " + price);
		}
		return fPrice;
	}

	private Map<String, String> putError(String key, String errorMessage) {
		errors = (errors == null) ? new HashMap<String, String>() : errors;
		errors.put(key, errorMessage);
		return errors;
	}

	private String getValue(HttpServletRequest request, String key, boolean required) throws Exception {
		String value = null;

		try {
			value = request.getParameter(key);
		} catch (Exception e) {
			if (required == true)
				throw new CreateReferenceException("missing required field " + key);
		}
		

		if (value == null || value.equals("") || value.equals(" ")) {
			if (required == true)
				throw new CreateReferenceException("blank required field " + key);
		}
		return value;
	}

}
