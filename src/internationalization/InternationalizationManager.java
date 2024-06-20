package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Manages internationalization resources for the application.
 * Provides methods to switch locales and retrieve localized strings.
 *
 * @author Daniel Aigbe
 * @version 1.0
 * @date 16/04/2024
 */
public class InternationalizationManager {
    private ResourceBundle messages;
    private Locale currentLocale;

    /**
     * Constructs an InternationalizationManager with specified language and country.
     *
     * @param language the initial language code
     * @param country the initial country code
     */
    public InternationalizationManager(String language, String country) {
        currentLocale = new Locale(language, country);
        loadResourceBundle();
    }

    /**
     * Loads the resource bundle based on the current locale.
     */
    private void loadResourceBundle() {
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    /**
     * Retrieves a string from the resource bundle based on the provided key.
     *
     * @param key the key for the desired string
     * @return the string associated with the key
     */
    public String getString(String key) {
        return messages.getString(key);
    }

    /**
     * Changes the locale and reloads the resource bundle.
     *
     * @param language the new language code
     * @param country the new country code
     */
    public void changeLocale(String language, String country) {
        currentLocale = new Locale(language, country);
        loadResourceBundle();
    }
}
