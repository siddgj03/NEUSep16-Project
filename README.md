# NEUSep16-Project

Tips & Requests:

- Please make src your Project's "Source folder". Otherwise all your package definitions will start with "src.org.x.x.x" and it's supposed to be "org.x.x.x".
  If we have different file structures, it won't even compile for some of us and we can't test anything without having to change it all :)

- Try using this code to get the files in the "data" folder
  - String path = new File("data/something.txt").getAbsolutePath();
  - So this way others can execute your code without having to rename all the local computer paths ("C:/Someone's/Private/Computer")

-- from BrowseInventory group, Nov 23rd 2016

Please check out the Folder src/org/neu/project/service Where we provide the InventroySearchControl class for filtering and InventorySortControl class for sorting.

---from Group02_desgining Class and top view team, Nov 22th 2016


Please check out the Folder src/org/neu/project where We provide the class of Inventory, Dealer, Vehicle for each team to use.

for BrowsingInventory team. We will call the Class Named CustomerBrowsingInventory and DealerBrowsingInventory with passing dealerID(String) to your team. Our suggestion is to create a super class of BrowsingInventory for inheritance so that there is little change needed between the customer view and dealer view.

for Specials team. We will call the Class Named BrowsingSpecials with passing dealerID(String);

---from Group02_desgining Class and top view team, Nov 20th 2016