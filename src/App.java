import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class App  extends JFrame implements ActionListener{

      JMenuBar  barraMenu;
      JMenu     cadastro;
      JMenuItem jmiCliente;

      JLabel lbValorOriginal, lbMoraMulta, lbDiaAtraso, lbMultaFixa, lbJurDia, lbTotalJuros, lbTotalBoleto, lbValorEstenso ;
      TextField  tfValorOriginal, tfMoraMulta, tfDiaAtraso, tfMultaFixa, tfJurDia, tfTotalJuros, tfTotalBoleto, tfValorEstenso ;
      JButton btLimpar, btcalcular;

      BigDecimal valorOriginal;
      BigDecimal juroMonetario;
      BigDecimal diasEmAtraso;

    public App(){

        setTitle("Calculador de Boleto ");
        setSize(400, 400);
        setLocation(500, 180);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        this.valorOriginal = BigDecimal.ZERO;
        this.juroMonetario = BigDecimal.ZERO;
        this.diasEmAtraso = BigDecimal.ZERO;
    }
    public static void main(String[] args) throws Exception {
       
        JFrame janela = new App();
        janela.setVisible(true);
    }
    public void initComponents(){

        barraMenu = new JMenuBar();
        cadastro = new JMenu("Cadastro");

        jmiCliente = new JMenuItem("Cliente");
        jmiCliente.setFont(new Font("Arial", Font.BOLD, 14));
        //Adicionando os menu na barra de menu
        setJMenuBar(barraMenu);
        barraMenu.add(cadastro);
          
        cadastro.add(jmiCliente);
    
        lbValorOriginal = new JLabel("Valor Original");
        lbValorOriginal.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbValorOriginal);
        lbValorOriginal.setForeground(Color.DARK_GRAY);
        lbValorOriginal.setBounds(20, 20, 150, 20);

        tfValorOriginal = new TextField();
        getContentPane().add(tfValorOriginal);
        tfValorOriginal.setBounds(20, 40, 150, 20);

        lbJurDia = new JLabel("Juro Diário");
        lbJurDia.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbJurDia);
        lbJurDia.setForeground(Color.DARK_GRAY);
        lbJurDia.setBounds(190, 20, 150, 20);

        tfJurDia = new TextField();
        getContentPane().add(tfJurDia);
        tfJurDia.setBounds(190, 40, 150, 20);
        
        lbMoraMulta = new JLabel("Nora Multa");
        lbMoraMulta.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbMoraMulta);
        lbMoraMulta.setBounds(20, 60, 150, 20);
        lbMoraMulta.setForeground(Color.DARK_GRAY);

        tfMoraMulta = new TextField();
        getContentPane().add(tfMoraMulta);
        tfMoraMulta.setBounds(20, 80, 150, 20);

        lbTotalJuros = new JLabel("total de Juros");
        lbTotalJuros.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbTotalJuros);
        lbTotalJuros.setBounds(190, 60, 150, 20);
        lbTotalJuros.setForeground(Color.DARK_GRAY);

        tfTotalJuros = new TextField();
        getContentPane().add(tfTotalJuros);
        tfTotalJuros.setBounds(190, 80, 150, 20);

         lbDiaAtraso = new JLabel("Dias Atraso");
        lbDiaAtraso.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbDiaAtraso);
        lbDiaAtraso.setBounds(20, 100, 150, 20);
        lbDiaAtraso.setForeground(Color.DARK_GRAY);

        tfDiaAtraso = new TextField();
        getContentPane().add(tfDiaAtraso);
        tfDiaAtraso.setBounds(20, 120, 150, 20);

        lbTotalBoleto = new JLabel("Valor Calculado do boleto");
        lbTotalBoleto.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbTotalBoleto);
        lbTotalBoleto.setBounds(190, 100, 150, 20);
        lbTotalBoleto.setForeground(Color.DARK_GRAY);

        tfDiaAtraso = new TextField();
        getContentPane().add(tfDiaAtraso);
        tfDiaAtraso.setBounds(190, 120, 150, 20);

         lbMultaFixa = new JLabel("Multa fixa");
        lbMultaFixa.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbMultaFixa);
        lbMultaFixa.setBounds(20, 140, 150, 20);
        lbMultaFixa.setForeground(Color.DARK_GRAY);

        tfMultaFixa = new TextField();
        getContentPane().add(tfMultaFixa);
        tfMultaFixa.setBounds(20, 160, 150, 20);

         lbValorEstenso = new JLabel("Valor por extenso");
        lbValorEstenso.setFont(new Font("Arial", Font.BOLD, 12));
        getContentPane().add(lbValorEstenso);
        lbValorEstenso.setBounds(20, 220, 150, 20);
        lbValorEstenso.setForeground(Color.DARK_GRAY);

        tfValorEstenso = new TextField();
        getContentPane().add(tfValorEstenso);
        tfValorEstenso.setBounds(20, 240, 320, 20);

        btLimpar = new JButton("Limpar");
        getContentPane().add(btLimpar);
        btLimpar.setBounds(120, 280, 100, 20);

        btcalcular = new JButton("Calcular");
        getContentPane().add(btcalcular);
        btcalcular.setBounds(230, 280, 100, 20);

        btLimpar.addActionListener(this);
        btcalcular.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btLimpar){
            limparCampos();
        }
        if(e.getSource()== btcalcular){
          //   juroDoDia();
            juroPorDia();
            totalGeraldeJuros();
            valortotalBoleto();
            numeroPorEstenso();
           
        }
    }
//************************************************************************************ */
    private BigDecimal juroPorDia() {
        String sValor = tfValorOriginal.getText().replace(",", ".");
        String sMulta = tfMoraMulta.getText().replace(",", ".");

        BigDecimal valorOriginal = new BigDecimal(sValor);
        BigDecimal taxa = new BigDecimal(sMulta).divide(new BigDecimal("100"));

        BigDecimal juroDia = valorOriginal.multiply(taxa);
        BigDecimal jd = juroDia.setScale(2, RoundingMode.HALF_UP);

        tfJurDia.setText(String.valueOf(jd));

        return jd;
    }
     private BigDecimal totalGeraldeJuros() {

        String diaemAtraso = tfDiaAtraso.getText().replace(",", ".");
        BigDecimal atd = new BigDecimal(diaemAtraso);
        BigDecimal atraso = atd.setScale(2, RoundingMode.HALF_UP);
        BigDecimal Totaljuros = juroPorDia().multiply(atraso);
    
        tfTotalJuros.setText(String.valueOf(Totaljuros));
        return Totaljuros;
    }
private BigDecimal valortotalBoleto() {

        String sValor = tfValorOriginal.getText().replace(",", ".");
        String sMulta = tfMultaFixa.getText().replace(",", ".");

        BigDecimal valorOriginal = new BigDecimal(sValor);
        BigDecimal multamonetaria = new BigDecimal(sMulta);

        BigDecimal juros = juroPorDia();
        BigDecimal juroTotal = totalGeraldeJuros();
        
         BigDecimal vb = valorOriginal.add(multamonetaria).add(juros).add(juroTotal);
         BigDecimal valorBoleto = vb.setScale(2, RoundingMode.HALF_UP);
       
         tfTotalBoleto.setText(String.valueOf(valorBoleto));
        
        return valorBoleto;
    }
    //********************************************************************* */
    public void numeroPorEstenso(){
       //  try{          
            String entry = "";
      //  do {
       // JOptionPane.showMessageDialog(null,"Escreva um número inteiro ou um valor em reais: ");
       BigDecimal  vBoleto = valortotalBoleto();
       
     //  entry = tf_numeracao.getText().replaceAll("\\.", ""); 
        entry = String.valueOf(vBoleto);
            try {           
               if (entry.contains(",") || entry.contains(".")) {                     
                    tfValorEstenso.setText(NumeroExtenso.get(new BigDecimal(
                entry.replace(",", ".")), "real", "reais", "centavo", 
                "centavos"));
                } else {
                    tfValorEstenso.setText(NumeroExtenso.get(Long.parseLong(entry)));
                    }
               
                } catch (NumberFormatException e) {
                    tfValorEstenso.setText("Número inválido.");
                   // continue;
                }
          //  } while (!"".equals(entry));
    }
    public void limparCampos(){
        tfValorOriginal.setText("");
        tfMoraMulta.setText("");
        tfMultaFixa.setText("");
        tfDiaAtraso.setText("");
        tfJurDia.setText("");
        tfTotalJuros.setText("");
        tfTotalBoleto.setText("");
        tfValorEstenso.setText("");
    }
}
