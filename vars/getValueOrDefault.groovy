def call(String actualValue,String defaultValue) {
    echo "the autual value $actualValue "
    if (!actualValue?.trim()) {
        return defaultValue?.trim()
    }
    return actualValue?.trim()
}
