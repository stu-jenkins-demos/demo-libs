def call(String actualValue,String defaultValue) {
    echo "the autual value $actualValue "
    echo "the default value $defaultValue"

    if (!actualValue){
        print "its null test"
    }
    //if (!actualValue?.trim()) {
    if (!actualValue) {
        echo "sending defauly value $defaultValue"
        return defaultValue?.trim()
    }
    echo "sending actual value $actualValue"
    return actualValue?.trim()
}
