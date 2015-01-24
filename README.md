# geesiam
Geesiam: encode and push messages

Parameters:
- did: your device id
- pph: your ideally non-empty passphrase, only you know this passphrase, it is not transmitted to the GCM infrastructure and not stored on the Google App Engine
- enc: {"false"}, only used if the message text is already encoded on the local machine (if you want to send an already encoded message text via your browser, check the "encoded locally" checkbox)
- msg: your to-be-pushed message text
- urlEnc: the message might need to be URL-encoded
