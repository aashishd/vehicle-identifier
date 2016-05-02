package com.ashish.vehicleIdentifier.exceptions;


public enum ErrorCodes
{

    E001("We have found and error in XML file structure."),

    E002("Input stream sent by user is empty."),

    E003("Please upload an xml file only."),

    E004("I/O Exception occured while getting the file stream."),

    E005("XML schema structue is incorrect as per the objects."),

    E006("File format is incorrect.");

    private final String message;

    private ErrorCodes(final String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
