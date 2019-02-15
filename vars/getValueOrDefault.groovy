def call(String actualValue,String defaultValue) {
    echo "the autual value $actualValue "
    echo "the default value $defaultValue"
    if (!actualValue?.trim()) {
        return defaultValue?.trim()
    }
    return actualValue?.trim()
}
