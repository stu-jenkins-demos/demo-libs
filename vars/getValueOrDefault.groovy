def call(String actualValue,String defaultValue) {
    echo "the autual value $actualValue "
    echo "the default value $defaultValue"
    if (!actualValue?.trim()) {
        echo "sending $defaultValue"
        return defaultValue?.trim()
    }
    echo "sending $actualValue"
    return actualValue?.trim()
}
