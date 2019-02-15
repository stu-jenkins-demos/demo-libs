def call(String actualValue,String defaultValue) {
    echo "the autual value $actualValue "
    echo "the default value $defaultValue"

    if (!actualValue){
        print "its null test"
    }
    //if (!actualValue?.trim()) {
    if (!actualValue) {
        echo "not set $actualValue"
        echo "sending defauly value $defaultValue"
        return defaultValue?.trim()
    }else{
        echo " set $actualValue"
    }
    echo "sending actual value $actualValue"
    return actualValue?.trim()
}
