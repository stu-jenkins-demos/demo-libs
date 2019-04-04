def call(teamName, recipe) {

    sh """
    generate_post_data()
    {
      cat <<EOF
    {
      "name": "$teamName",
      "members": [
        {
          "role": "TEAM_ADMIN",
          "id": "admin"
        }
      ],
      "icon": {
        "color": "#dd6669",
        "name": "hexagons"
      },
      "recipe": "$recipe"
    }
    EOF
    }
    #curl -s -u $CJOCUSER:$CJOCPASSWD https://cjejp.core.pscbdemos.com/cjoc/blue/rest/cjoc/teams/ -H "Content-Type: application/json" -d "\$(generate_post_data $TEAMNAME $RECIPE)"

    #curl  -s -u $CJOCUSER:$CJOCPASSWD $CORECURL/cjoc/blue/rest/cjoc/teams/$lTEAMNAME/?pretty=true| jq '. | {mmstatus: .status}'
    
    """

}
