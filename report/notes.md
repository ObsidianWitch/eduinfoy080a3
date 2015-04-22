% Software Architectures - Service Oriented Architectures - Web Services

# Links

* <http://docs.oasis-open.org/wsbpel/2.0/OS/wsbpel-v2.0-OS.html#_Toc164738514>

# Exercise 1: BPEL processes

response:
~~~
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
    <soapenv:Body>
        <LibrarySearchResponse xmlns="urn:soft.librarysearch" xmlns:tns="urn:soft.librarysearch">
            <tns:query/>
            <tns:books>
                <searchBooksResponse xmlns="urn:soft.vub.ac.be/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <book xmlns="">
                        <author>Robert Ludlum</author>
                        <year>2004</year>
                        <isbn>95248457</isbn>
                        <language>en</language>
                        <publisher>Orion</publisher>
                        <title>The Bourne Identity</title>
                    </book>
                    <book xmlns="">
                        <author>Douglas Adams</author>
                        <year>2002</year>
                        <isbn>345453743</isbn>
                        <language>en</language>
                        <publisher>Del Rey</publisher>
                        <title>The Ultimate Hitchhiker's Guide to the Galaxy</title>
                    </book>
                    <book xmlns="">
                        <author>William Sleator</author>
                        <year>2008</year>
                        <isbn>810993562</isbn>
                        <language>en</language>
                        <publisher>Amulet Books</publisher>
                        <title>Test</title>
                    </book>
                    <book xmlns="">
                        <author>Jordan Belfort</author>
                        <year>2008</year>
                        <isbn>606259090</isbn>
                        <language>en</language>
                        <publisher>Hodder Paperback</publisher>
                        <title>The Wolf of Wall Street</title>
                    </book>
                </searchBooksResponse>
                <searchForBooksReturn xmlns="http://library.be" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <author>James, E. L.</author>
                    <date>3914-01-10T23:00:00.000Z</date>
                    <isbn>0345803485</isbn>
                    <language>English</language>
                    <publisher>Vintage Books</publisher>
                    <title>50 Shades of Grey</title>
                </searchForBooksReturn>
                <searchForBooksReturn xmlns="http://library.be" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <author>James Dashner</author>
                    <date>3914-04-20T22:00:00.000Z</date>
                    <isbn>0385388896</isbn>
                    <language>English</language>
                    <publisher>The Maze Runner Series</publisher>
                    <title>Test</title>
                </searchForBooksReturn>
                <searchForBooksReturn xmlns="http://library.be" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <author>William Sleator</author>
                    <date>3908-03-31T22:00:00.000Z</date>
                    <isbn>0810993562</isbn>
                    <language>English</language>
                    <publisher>Amulet Books</publisher>
                    <title>Test</title>
                </searchForBooksReturn>
                <searchForBooksReturn xmlns="http://library.be" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <author>Douglas Adams</author>
                    <date>3902-05-29T22:00:00.000Z</date>
                    <isbn>0345453743</isbn>
                    <language>English</language>
                    <publisher>Del Rey</publisher>
                    <title>The Ultimate Hitchhiker's Guide to the Galaxy</title>
                </searchForBooksReturn>
                <searchForBooksReturn xmlns="http://library.be" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <author>Michalewicz, Zbigniew  Fogel, David B.</author>
                    <date>3912-10-31T23:00:00.000Z</date>
                    <isbn>9783642061349</isbn>
                    <language>English</language>
                    <publisher>Del Rey</publisher>
                    <title>How to Solve It: Modern Heuristics</title>
                </searchForBooksReturn>
            </tns:books>
        </LibrarySearchResponse>
    </soapenv:Body>
</soapenv:Envelope>
~~~

problem: searchBooksResponse for urn:soft.vub.ac.be & searchForBooksReturn for
http://library.be

->

we would like the same tags for both types of books

# Exercise 2: Integration with Legacy Software

# Exercise 3: Architecture
