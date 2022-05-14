<#macro layout currentResource>
    <html lang="en">
    <head>
        <link rel="stylesheet" type="text/css" href="../static/style.css"/>
        <meta name=viewport content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/reset.css">
        <link rel="stylesheet" href="/style.css">
        <link rel="icon" type="image/svg" href="/favicon.svg">

        <title>Kotlin spring starter</title>
    </head>
    <body>
    <header>
        <div class="container">
            <h1>Kotlin spring starter</h1>
        </div>
    </header>
    <section class="callout">
        <div class="container">
            a <span class="branded">FreshCloud[]</span> application with
            <span class="branded">hexa</span> and <span class="branded">opa</span> support.
        </div>
    </section>
    <main>
        <#nested>
    </main>
    <footer>
        <div class="container">
            <script>document.write("©" + new Date().getFullYear());</script>
            Initial Capacity, Inc. All rights reserved.
        </div>
    </footer>
    </body>
    </html>
</#macro>
