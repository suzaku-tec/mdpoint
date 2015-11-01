# mdpoint

## summary
This project provides the ability to the presentation in Markdown.

## Story
Markdown presentation might reveal.js, but it is necessary to edit the html file, it is troublesome.
I made in order to solve such a hassle.
There is a reveal-ck to those similar but, in order to create it from making a once file, the command will be multiple.
This project aims to release of hassle.
Therefore, it provides as much as possible environment for the presentation in one shot command.

## Prerequisite
- That Java 8 is installed
- That there is a feeling that you want to ease the presentation
- It is tolerant of bug

## How to use
java -jar mdpoint.jar {markdown file path} [separator]

Please Markdown files are always set.
People who do not set do not know what to do presentation of.
Separator, please set a string of a page break.
If you do not specify a separator, which is the default value "---" will be set.

After starting in the above command to access the browser.
When's default, the server will start in the 8080 port.
This mechanism Since you are using a SpringFW, you can change the port.
When the boot is complete "http: // localhost: 8080" Please try to access.
It should become a state which surely can be a presentation. Maybe...