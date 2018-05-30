package epam;

public enum DIFFERENT_ELEMENTS_PAGE {

    ACCCAT("Acccat", new String[]{"acccatid"}, "acccatText", "dlg7Matchcode", "Zutritts\nkategorie", "Text");

    String[] optionsArray = new String[]{
            "Service",
            "Support",
            "Dates",
            "Complex Table",
            "Simple Table",
            "Table with pages",
            "Different elements"
    };

    String[] elementArray = new String[]{
            "Water",
            "Earth",
            "Wind",
            "Fire"
    };

    String[] materialArray = new String[]{
            "Gold",
            "Silver",
            "Bronze",
            "Selen"
    };

    String[] colorsArray = new String[]{
            "Red",
            "Green",
            "Blue",
            "Yellow"
    };

    String[] logsChecked = new String[]{
            "Water: condition changed to true",
            "Wind: condition changed to true",
            "metal: value changed to Selen",
            "Colors: value changed to Yellow"
    };

    String[] logsUnchecked = new String[]{
            "Wind: condition changed to false",
            "Water: condition changed to false"
    };

    DIFFERENT_ELEMENTS_PAGE(String acccat, String[] strings, String acccatText, String dlg7Matchcode, String s, String text) {
    }
}
