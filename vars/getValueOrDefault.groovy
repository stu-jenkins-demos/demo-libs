def call(String actualValue,String defaultValue) {
    echo "the autual value $actualValue "
    echo "the default value $defaultValue"

    if (actualValue = "") {
       echo "caught a null"
    }


    if (!actualValue?.trim()) {
        echo "sending defauly value $defaultValue"
        return defaultValue?.trim()
    }
    echo "sending actual value $actualValue"
    return actualValue?.trim()
}
