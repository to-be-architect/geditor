yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title("Ge")
        meta('http-equiv': 'Content-Type', content: 'text/html; charset=utf-8')
        meta('name': "viewport", content: "width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")

        link(rel: 'icon', href: 'favicon.ico', type: "image/x-icon")
        link(rel: "stylesheet", type: "text/css", href: "styles/grapheditor.css")

        script(src: '/js/urlParams.js') {}
        script(src: '/js/App.js') {}

        script(src: '/js/Init.js') {}
        script(src: '/js/pako.min.js') {}
        script(src: '/js/base64.js') {}
        script(src: '/js/jscolor.js') {}
        script(src: '/js/sanitizer.min.js') {}
        script(src: '/js/mxClient.js') {}
        script(src: '/js/EditorUi.js') {}
        script(src: '/js/Editor.js') {}
        script(src: '/js/Sidebar.js') {}
        script(src: '/js/Graph.js') {}
        script(src: '/js/Format.js') {}
        script(src: '/js/Shapes.js') {}
        script(src: '/js/Actions.js') {}
        script(src: '/js/Menus.js') {}
        script(src: '/js/Toolbar.js') {}
        script(src: '/js/Dialogs.js') {}
    }
    body(class: 'geEditor') {
        script(src: '/js/geEditor.js') {}
    }
}
