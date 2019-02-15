def call(String actualValue,String defaultValue) {
    //echo "the autual value [$actualValue] "
    //echo "the default value [$defaultValue]"

//    if (!actualValue?.trim()) {
//        echo "string is null or empty"
//    }
//    if (actualValue.trim() == "null") {
//        echo "string is really null or empty"
//    }

    //if ((!actualValue?.trim()) or actualValue.trim() == "null") {
    //if (actualValue.trim() == "null") {
    if (!(actualValue?.trim())){
        //if ((!actualValue)){
        //echo "not set $actualValue"
        //echo "sending defauly value $defaultValue"
        return defaultValue?.trim()
    } else {
        //echo " set $actualValue"
        //echo "sending actual value $actualValue"
        return actualValue?.trim()
    }
}