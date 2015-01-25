# geesiam
Geesiam: encode and push messages - https://geesiam-dev.appspot.com/

Geesiam ['ʤiːsɪəm] allows you to receive and manage (end-to-end) encoded messages, which are pushed from a web browser or from within your own source code over a basically insecure internet connection to your Android mobile device just using HTTP POST requests to the Geesiam backend. The Geesiam Android client is available on Google Play: https://play.google.com/store/apps/details?id=com.geesiamdev.geesiam.

The Geesiam backend (a Google App Engine application), found on https://geesiam-backend.appspot.com, communicates with the Google Cloud Messaging (GCM) infrastructure and does not store any (!) data. The encoded messages are directly transferred to the GCM infrastructure and only remain there until the transmission to the Android client (max. 7 days). The passphrase needed for encoding and decoding of the messages is arbitrary and is only stored on the Android device. Messages can either be encoded by the Geesiam backend or yourself.

Geesiam is perfectly suited for development projects that need to push messages to mobile devices (e.g. Raspberry Pi, Linux servers, cloud applications).

This exemplary code shows how to encode and push messages to your Android mobile device.

Parameters:
- did: your device id
- pph: your ideally non-empty passphrase, only you know this passphrase, it is not transmitted to the GCM infrastructure and not stored on the Google App Engine
- enc: {"false"}, only used if the message text is already encoded on the local machine (if you want to send an already encoded message text via your browser, check the "encoded locally" checkbox)
- msg: your to-be-pushed message text
- urlEnc: the message might need to be URL-encoded

Exemplary projects making use of Geesiam:
- Raspberry Pi: motion detector registers movement and sends message to Android device
- Raspberry Pi: temperature / humidity sensor detects changes and sends message to Android device
- Cloud applications (e.g. Google App Engine): push the lowest gas prices around on your smartphone
- Cloud applications (such as Amazon Web Services): EC2 processes data and informs on the completion by sending a message to the tablet
- Monitoring of homepages and notification of changes
- Notification of new RSS feeds
- Automated execution of scripts (Linux crontab, Windows Task Scheduler) with subsequent notification to the Android device
- Notification of server non-availability (ping)
- Android tablet with SL4A: Tasker registers an event (e.g. attempted theft) and triggers a Python script pushing some information to the Android smartphone
- Google Apps Script: create scripts for Google's services (Drive, Docs, Spreadsheet, Gmail, Calendar) and get 
immediately informed about custom events
