
/**
 * @author Ruby,Liao
 * SortUI in browse inventory page
 * FlowLayout to place title label and sort items horizontally
 * Pending addListeners
 */

class SortUI extends JPanel
{
	private SortUIPanel()
	{
		this.setLayout(new FlowLayout());
		String[] sortItems = {"Select Sort By","Price: High To Low","Price: Low To High",
                "Year: High To Low","Year: Low To High","Make: A - Z","Maker: Z - A",
                "Model: A - Z","Model: Z - A","Mileage: High To Low","Mileage: Low To High",
                "HWY MPG: High To Low","HWY MPG: Low To High","Exterior Color: A - Z",
                "Exterior Color: Z - A","Specials","Certified"};
		private JComboBox sortList = new JComboBox(sortItems);
		private JLabel sortLabel = new JLabel("Sort By:");
		add(sortLabel);
		add(sortList);
	}
}