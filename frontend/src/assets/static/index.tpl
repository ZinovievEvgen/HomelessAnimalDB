<!DOCTYPE html>
<html>
  <head>
      <title>{% TITLE %}</title>

      <meta http-equiv="content-type" content="text/html; charset=utf-8" />
      <meta name="viewport" content="width=device-width, user-scalable=no, maximum-scale=1.0, initial-scale=1.0, minimum-scale=1.0" />
      <meta http-equiv="X-UA-Compatible" content="ie=edge" />

      <link href="{% CLIENT_STYLE_SRC %}" rel="stylesheet" />
      <script defer src="{% CLIENT_SCRIPT_SRC %}"></script>
  </head>
  <body>
    {% BODY_SLOT_TOP %}
    <div id="{% ROOT_ELEMENT_NAME %}">
      {% ROOT_INNER %}
    </div>
    {% BODY_SLOT_BOTTOM %}
  </body>
</html>