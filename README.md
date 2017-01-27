# ERPDeliveryReceipt
##Bar or QR Code Scan Into iDempiere ERP affecting Kanban Board display
##Minimal code approach with direct database connection
##Quick open source reference for any Android Studio Project in that regard
##Database Connection URL and Credentials set in SharedPreferences for local phone persistence
##External ZXing code scan app download at first scan, one time only
##Scans are displayed into an Array List
##Array List not lost when orientation switched from horizontal to vertical
##Array List written to database on Update DB
##Direct Database Connection using AsynTask Background thread
##Update SQL statement into Table of choice
##UPDATE <Table> SET DocStatus = 'IP' WHERE <Field> = 'Scanned'
#On iDempiere ERP side, a Kanban Board is easily setup using Red1 Ninja plugin
##Kanban Board document has DocStatus field and plugin code for M<Document>.java implements DocAction
