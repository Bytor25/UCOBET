package co.edu.uco.ucobet.generales.crosscutting.helpers;

public final class TextHelper {

	public static final String EMPTY = "";

	private TextHelper() {

	}

	public static final boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static final String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static final String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static final boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static final boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}

	public static final String applyTrim(final String string) {
		return getDefault(string).trim();
	}

}
