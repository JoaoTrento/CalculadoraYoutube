package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CalculadoraDark extends JFrame implements ActionListener{

	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFielDisplay;
	private Color corBotao;
	private Color corFundo;
	private Color corTexto;
	private Color corLinha;
	private int x;
	private int y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraDark frame = new CalculadoraDark();
					frame.setLocationRelativeTo(frame);
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setOpacity((float)0.99);
					frame.setTitle("Calculadora");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // parei aqui --------------------------------------------------------------------------------------------------------------
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraDark() {
		
		corBotao = new Color(70, 71, 74);
		corFundo = new Color(53, 53, 53);
		corLinha = new Color(53, 53, 53);
		corTexto = Color.white;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 490);
		contentPane = new JPanel();
		contentPane.setBackground(corFundo);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		movimentarTela();
		
		JLabel btnModo = new JLabel();
		btnModo.setIcon(new ImageIcon(CalculadoraDark.class.getResource("/imagens/botaoEscuro.png")));
		btnModo.setBounds(0, -50, 300, 400);
		contentPane.add(btnModo);
		
		JButton bntFechar = criarBotao("x", 280, 0, 40, 30);
		bntFechar.addActionListener(this);
		contentPane.add(bntFechar);
		
		textFielDisplay = new JTextField();
		textFielDisplay.setBorder(null);
		textFielDisplay.setEditable(false);
		textFielDisplay.setFont(new Font("Tahoma", Font.PLAIN, 48));
		textFielDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		textFielDisplay.setText("0");
		textFielDisplay.setForeground(Color.white);
		textFielDisplay.setBounds(0, 32, 320, 60);
		textFielDisplay.setBackground(corFundo);
		contentPane.add(textFielDisplay);
		textFielDisplay.setColumns(10);
		
		JButton bntApagar = criarBotao("C", 0, 90, 160, 80);
		bntApagar.addActionListener(this);
		contentPane.add(bntApagar);
		
		JButton bntMultiplicacao = criarBotao("*", 160, 90, 80, 80);
		bntMultiplicacao.addActionListener(this);
		contentPane.add(bntMultiplicacao);
		
		JButton bntDivisao = criarBotao("/", 240, 90, 80, 80);
		bntDivisao.addActionListener(this);
		contentPane.add(bntDivisao);
		
		JButton bntSubtracao = criarBotao("-", 240, 170, 80, 80);
		bntSubtracao.addActionListener(this);
		contentPane.add(bntSubtracao);
		
		JButton bntAdicao = criarBotao("+", 240, 250, 80, 80);
		bntAdicao.addActionListener(this);
		contentPane.add(bntAdicao);
		
		JButton bntIgual = criarBotao("=", 240, 330, 80, 160);
		bntAdicao.addActionListener(this);
		contentPane.add(bntIgual);
		
		JButton bntZero = criarBotao("0", 0, 410, 160, 80);
		bntZero.addActionListener(this);
		contentPane.add(bntZero);
		
		JButton bntPonto = criarBotao(".", 160, 410, 80, 80);
		bntPonto.addActionListener(this);
		contentPane.add(bntPonto);
		
		JPanel panelBotoesNumericos = new JPanel();
		panelBotoesNumericos.setBounds(0, 170, 240, 320);
		panelBotoesNumericos.setLayout(new GridLayout(4, 3));
		panelBotoesNumericos.setBorder(null);
		panelBotoesNumericos.setBackground(corFundo);
		panelBotoesNumericos.setOpaque(true);
		
		String[] botoesNumericos = {"7", "8", "9", "4", "5", "6", "1", "2", "3"}; // 1 a 9
		
		for (String botao : botoesNumericos) {
			JButton btn = new JButton(botao);
			btn.addActionListener(this);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			btn.setFont(new Font("Tahoma", Font.PLAIN, 36));
			btn.setForeground(corTexto);
			btn.setFocusPainted(false);
			btn.setBackground(corBotao);
			btn.setBorder(new LineBorder(corLinha, 2));
			panelBotoesNumericos.add(btn);
		}
		contentPane.add(panelBotoesNumericos);
		
		for (Component component : contentPane.getComponents()) {
		    if (component instanceof JButton) {
		        JButton btn = (JButton) component;
		        alternarCorBotao(btn);
		    }
		    if(component instanceof JPanel) {
		    	for(Component botoesPanel : ((JPanel)component).getComponents()) {
		    		if (botoesPanel instanceof JButton) {
				        JButton btn = (JButton) botoesPanel;
				        alternarCorBotao(btn);
				    }
		    	}
		    }
		}
	}
	private void alternarCorBotao(JButton jButton) {
		jButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jButton.setBackground(corFundo);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				jButton.setBackground(corBotao);
			}
		});
	}
	
	private JButton criarBotao(String textoBotao, int x, int y, int width, int height) {
		JButton jbutton = new JButton(textoBotao);
		jbutton.setHorizontalAlignment(SwingConstants.CENTER);
		jbutton.setFont(new Font("Tahoma", Font.PLAIN, textoBotao.equalsIgnoreCase("X") ? 20 : 36));
		jbutton.setForeground(corTexto);
		jbutton.setFocusPainted(false);
		jbutton.setBackground(corBotao);
		jbutton.setBorder(new LineBorder(corLinha, 2));
		jbutton.setBounds(x, y, width, height);
		
		return jbutton;
	}

	private void movimentarTela() {
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if("=".equals(comando)) {
			String expressao = textFielDisplay.getText();
			double resultado = verificarExpressao(expressao);
			textFielDisplay.setText(Double.toString(resultado));
		}else if("C".equalsIgnoreCase(comando)) {
			// limpar display
			textFielDisplay.setText("0");
		}else if("x".equalsIgnoreCase(comando)) {
			dispose();
		}
	}
	
	private double verificarExpressao(String expressao) {
		
	}

}
