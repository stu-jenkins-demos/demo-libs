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
   
    
    """

}
