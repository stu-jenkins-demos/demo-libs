def call(String actualValue,String defaultValue) {
    if (actualValue.trim() == "null") {
    //if(actualValue) {
        return actualValue?.trim()
    }
    return defaultValue?.trim()
}
