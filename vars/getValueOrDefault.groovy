def call(String actualValue,String defaultValue) {
    if(actualValue) {
        return actualValue?.trim()
    }
    return defaultValue?.trim()
}
