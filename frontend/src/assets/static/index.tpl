<!DOCTYPE html>
<html>
  <head>
      <meta charset="utf-8">
      <title>{% TITLE %}</title>
      <script defer src="{% CLIENT_SCRIPT_SRC %}"></script>
      <link href="{% CLIENT_STYLE_SRC %}" rel="stylesheet" />
  </head>
  <body>
    {% BODY_SLOT_TOP %}
    <div id="{% ROOT_ELEMENT_NAME %}">
      {% ROOT_INNER %}
    </div>
    {% BODY_SLOT_BOTTOM %}
  </body>
</html>