//import javax.swing.JFrame;
//import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class Calculator extends JFrame
{
	public static final Color LIGHT_BLUE = new Color(80, 175, 255);
	public static final Font FONT = new Font("Arial", Font.PLAIN, 30);
	public static final Dimension NUMBER_DIMENSION= new Dimension(70, 66);
	public static final Dimension OPERATE_DIMENSION= new Dimension(55, 50);
	public static final Dimension MEMORY_DIMENSION= new Dimension(85, 50);
	public static final int WIDTH=400;
	public static final int HEIGHT=400;
	public static final String ERROR = "ERROR";
	
	private String operator = null;
	private boolean operated = false;
	private boolean recalled = false;
	private BigDecimal temp = null;
	private BigDecimal memory = null;
	
	private JTextField view = new JTextField("0");
	
	public static void main (String[] args)
	{
		Calculator calc = new Calculator("Ankur Sharma's Calculator");
		calc.setVisible(true);
	}
	
	public Calculator()
	{
		this("Calculator");
	}
	
	public Calculator(String title)
	{
		//JFrame
		super(title);
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setBackground(LIGHT_BLUE);
		
		//JPanel Groups
		JPanel Numbers = new JPanel();
		JPanel Operators = new JPanel();
		JPanel Memory = new JPanel();
		
		Numbers.setLayout(new FlowLayout());
		Operators.setLayout(new FlowLayout());
		Memory.setLayout(new FlowLayout());
		
		Numbers.setBackground(LIGHT_BLUE);
		Operators.setBackground(LIGHT_BLUE);
		Memory.setBackground(LIGHT_BLUE);
		
		Operators.setPreferredSize(new Dimension(65, 400));
		Memory.setPreferredSize(new Dimension(95, 400));
		
		//JPanels
		view.setFont(FONT);
		view.setEditable(false);
		
		JPanel Na = new JPanel();
		JPanel Nb = new JPanel();
		JPanel Nc = new JPanel();
		JPanel Nd = new JPanel();
		
		JPanel Oa = new JPanel();
		JPanel Ob = new JPanel();
		JPanel Oc = new JPanel();
		JPanel Od = new JPanel();
		JPanel Oe = new JPanel();
		
		JPanel Ma = new JPanel();
		JPanel Mb = new JPanel();
		JPanel Mc = new JPanel();
		JPanel Md = new JPanel();
		JPanel Me = new JPanel();
		
		Na.setBackground(LIGHT_BLUE);
		Nb.setBackground(LIGHT_BLUE);
		Nc.setBackground(LIGHT_BLUE);
		Nd.setBackground(LIGHT_BLUE);
		
		Oa.setBackground(LIGHT_BLUE);
		Ob.setBackground(LIGHT_BLUE);
		Oc.setBackground(LIGHT_BLUE);
		Od.setBackground(LIGHT_BLUE);
		Oe.setBackground(LIGHT_BLUE);
		
		Ma.setBackground(LIGHT_BLUE);
		Mb.setBackground(LIGHT_BLUE);
		Mc.setBackground(LIGHT_BLUE);
		Md.setBackground(LIGHT_BLUE);
		Me.setBackground(LIGHT_BLUE);
		
		//JButtons
		JButton dec = new JButton(".");
		dec.setFont(FONT);
		dec.setPreferredSize(NUMBER_DIMENSION);
		JButton neg = new JButton("+/-");
		neg.setFont(FONT);
		neg.setPreferredSize(NUMBER_DIMENSION);
		JButton N0 = new JButton("0");
		N0.setFont(FONT);
		N0.setPreferredSize(NUMBER_DIMENSION);
		JButton N1 = new JButton("1");
		N1.setFont(FONT);
		N1.setPreferredSize(NUMBER_DIMENSION);
		JButton N2 = new JButton("2");
		N2.setFont(FONT);
		N2.setPreferredSize(NUMBER_DIMENSION);
		JButton N3 = new JButton("3");
		N3.setFont(FONT);
		N3.setPreferredSize(NUMBER_DIMENSION);
		JButton N4 = new JButton("4");
		N4.setFont(FONT);
		N4.setPreferredSize(NUMBER_DIMENSION);
		JButton N5 = new JButton("5");
		N5.setFont(FONT);
		N5.setPreferredSize(NUMBER_DIMENSION);
		JButton N6 = new JButton("6");
		N6.setFont(FONT);
		N6.setPreferredSize(NUMBER_DIMENSION);
		JButton N7 = new JButton("7");
		N7.setFont(FONT);
		N7.setPreferredSize(NUMBER_DIMENSION);
		JButton N8 = new JButton("8");
		N8.setFont(FONT);
		N8.setPreferredSize(NUMBER_DIMENSION);
		JButton N9 = new JButton("9");
		N9.setFont(FONT);
		N9.setPreferredSize(NUMBER_DIMENSION);
		
		JButton plus = new JButton("+");
		plus.setFont(FONT);
		plus.setPreferredSize(OPERATE_DIMENSION);
		JButton minus = new JButton("-");
		minus.setFont(FONT);
		minus.setPreferredSize(OPERATE_DIMENSION);
		JButton mult = new JButton("*");
		mult.setFont(FONT);
		mult.setPreferredSize(OPERATE_DIMENSION);
		JButton div = new JButton("/");
		div.setFont(FONT);
		div.setPreferredSize(OPERATE_DIMENSION);
		JButton sol = new JButton("=");
		sol.setFont(FONT);
		sol.setPreferredSize(OPERATE_DIMENSION);
		
		JButton Clr = new JButton("Clr");
		Clr.setFont(FONT);
		Clr.setPreferredSize(MEMORY_DIMENSION);
		JButton MR = new JButton("MR");
		MR.setFont(FONT);
		MR.setPreferredSize(MEMORY_DIMENSION);
		JButton MC = new JButton("MC");
		MC.setFont(FONT);
		MC.setPreferredSize(MEMORY_DIMENSION);
		JButton Mplus = new JButton("M+");
		Mplus.setFont(FONT);
		Mplus.setPreferredSize(MEMORY_DIMENSION);
		JButton Mminus = new JButton("M-");
		Mminus.setFont(FONT);
		Mminus.setPreferredSize(MEMORY_DIMENSION);
		
		//Add Listener to Buttons
		N0.addActionListener(new NumberListener());
		N1.addActionListener(new NumberListener());
		N2.addActionListener(new NumberListener());
		N3.addActionListener(new NumberListener());
		N4.addActionListener(new NumberListener());
		N5.addActionListener(new NumberListener());
		N6.addActionListener(new NumberListener());
		N7.addActionListener(new NumberListener());
		N8.addActionListener(new NumberListener());
		N9.addActionListener(new NumberListener());
		dec.addActionListener(new NumberListener());
		neg.addActionListener(new NegationListener());
		
		plus.addActionListener(new OperatorListener());
		minus.addActionListener(new OperatorListener());
		mult.addActionListener(new OperatorListener());
		div.addActionListener(new OperatorListener());
		sol.addActionListener(new ResultListener());
		
		Clr.addActionListener(new MemoryListener());
		MR.addActionListener(new MemoryListener());
		MC.addActionListener(new MemoryListener());
		Mplus.addActionListener(new MemoryListener());
		Mminus.addActionListener(new MemoryListener());
		
		//Add to Panels
		Na.add(N7);
		Na.add(N8);
		Na.add(N9);
		Nb.add(N4);
		Nb.add(N5);
		Nb.add(N6);
		Nc.add(N1);
		Nc.add(N2);
		Nc.add(N3);
		Nd.add(dec);
		Nd.add(N0);
		Nd.add(neg);
		
		Oa.add(mult);
		Ob.add(div);
		Oc.add(plus);
		Od.add(minus);
		Oe.add(sol);
		
		Ma.add(Clr);
		Mb.add(MR);
		Mc.add(MC);
		Md.add(Mplus);
		Me.add(Mminus);
		
		//Add to Window
		Numbers.add(Na);
		Numbers.add(Nb);
		Numbers.add(Nc);
		Numbers.add(Nd);
		
		Operators.add(Oa);
		Operators.add(Ob);
		Operators.add(Oc);
		Operators.add(Od);
		Operators.add(Oe);
		
		Memory.add(Ma);
		Memory.add(Mb);
		Memory.add(Mc);
		Memory.add(Md);
		Memory.add(Me);
		
		add(view, BorderLayout.NORTH);
		add(Memory, BorderLayout.WEST);
		add(Numbers, BorderLayout.CENTER);
		add(Operators,BorderLayout.EAST);
	}
	
	private class NumberListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String number = e.getActionCommand();
			String current = view.getText();
			int maxLength = 21;
			if(current.charAt(0)=='-')
				maxLength++;
			if((current.equals("0")||current.equals(ERROR))||operated||recalled)
			{
				view.setText(number);
				if(number==".")
					view.setText("0.");
			}
			else if(current.length()<maxLength)
			{
				view.setText(current+number);
			}
			operated = false;
			recalled = false;
		}
	}
	
	private class NegationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String current = view.getText();
			if((temp==null || !operated) && new BigDecimal(current).doubleValue()!=0)
			{
				if(current.charAt(0)=='-')
					view.setText(current.substring(1,current.length()));
				else
					view.setText("-"+current);
			}
		}
	}
	
	private class MemoryListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			switch(command)
			{
				case "Clr":
					view.setText("0");
					temp = null;
					operator = null;
					operated = false;
					break;
				case "MR":
					if(memory!=null)
					{
						view.setText(memory.toString());
						checkView();
						operated = false;
						recalled = true;
					}
					break;
				case "MC":
					memory = null;
					break;
			}
			
			if(command.equals("M+")||command.equals("M-"))
			{
				try
				{
					if(operator!=null && !operated)
					{
						operate();
						operated=true;
						operator=null;
					}
					BigDecimal current = new BigDecimal(view.getText());
					switch(command)
					{
						case "M+":
							if(memory==null)
								memory = current;
							else
								memory = memory.add(current);
							break;
						case "M-":
							if(memory==null)
								memory = new BigDecimal("0").subtract(current);
							else
								memory = memory.subtract(current);
							break;
					}
					memory = BigDecimal.valueOf(memory.doubleValue());
					if(memory.doubleValue()==memory.intValue())
						memory = BigDecimal.valueOf(memory.intValue());
				}
				catch(Exception error)
				{
					view.setText(ERROR);
				}
			}
		}
	}
	
	private class OperatorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				if(operator!=null && !operated)
				{
					operate();
				}
				else
					temp = new BigDecimal(view.getText());
				operator = e.getActionCommand();
				operated = true;
			}
			catch(Exception error)
			{
				view.setText(ERROR);
			}
		}
	}
	
	private class ResultListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				{
					if(operator==null && temp==null)
						setView();
					if(!operated)
					{
						operate();
						operator = null;
						temp = null;
						operated = true;
					}
				}
			}
			catch(Exception error)
			{
				view.setText(ERROR);
			}
		}
	}
	
	private void operate()
	{
		BigDecimal current = new BigDecimal(view.getText());
		if(operator!=null)
		{
			switch(operator)
			{
				case "+":
					temp = temp.add(current);
					break;
				case "-":
					temp = temp.subtract(current);
					break;
				case "*":
					temp = temp.multiply(current);
					break;
				case "/":
					try
					{
						temp = temp.divide(current);
					}
					catch(ArithmeticException ae)
					{
						temp = BigDecimal.valueOf(temp.doubleValue()/current.doubleValue());
					}
					break;
			}
			setView();
		}
	}
	
	private void setView()
	{
		boolean nulled = temp==null;
		if(nulled)
			temp = new BigDecimal(view.getText());
		temp = BigDecimal.valueOf(temp.doubleValue());
		if(temp.doubleValue()==temp.intValue())
			temp = BigDecimal.valueOf(temp.intValue());
		view.setText(temp.toString());
		if(nulled)
			temp = null;
		checkView();
	}
	
	private void checkView()
	{
		String current = view.getText();
		int currentLength = current.length();
		boolean isNeg = current.charAt(0)=='-';
		int maxLength = 21;
		if(current.contains("E"))
		{
			currentLength = current.indexOf("E");
		}
		if(isNeg)
		{
			currentLength--;
			maxLength++;
		}
		if(currentLength>21)
		{
			if(current.contains("E"))
			{
				int Eposition = current.indexOf("E");
				view.setText(current.substring(0,maxLength-(current.length()-Eposition))+current.substring(Eposition,current.length()));
			}
			else
				view.setText(current.substring(0,maxLength));
		}
	}
}
//write .txt file ReadMe of procedure