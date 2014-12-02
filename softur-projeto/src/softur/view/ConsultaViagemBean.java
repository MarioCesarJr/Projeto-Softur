package softur.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import softur.entities.Viagem;
import softur.repository.Viagens;
import softur.service.GestaoViagem;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@ManagedBean
public class ConsultaViagemBean {

	private List<Viagem> viagensList;
	private Viagem viagemSelecionada;

	@PostConstruct
	public void init() {
		Viagens viagens = new Viagens();
		this.viagensList = viagens.todos();
	}
	
	public String excluir(){
		GestaoViagem gestaoViagem = new GestaoViagem();
		gestaoViagem.excluir(viagemSelecionada);
		init();
		return "";
	}

	public List<Viagem> getViagensList() {
		return viagensList;
	}

	public Viagem getViagemSelecionada() {
		return viagemSelecionada;
	}

	public void setViagemSelecionada(Viagem viagemSelecionada) {
		this.viagemSelecionada = viagemSelecionada;
	}
	
    public void imprimir(){
		
			Document document = new Document(PageSize.A4);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			try{
				
				PdfWriter.getInstance(document, baos);
				
				
				Viagens viagens = new Viagens();
				
				document.open();
				
				//document.add(new Paragraph(" TOTAL DE VEICULOS \n \n"));
				
				Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
				
				Paragraph p = new Paragraph("Relatório de Viagem",f);
				p.setAlignment(Element.ALIGN_CENTER);
				p.setSpacingAfter(20);
				document.add(p);
				
				
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date currentDate = new Date();
				String date = formatter.format(currentDate);
				//document.add(new Paragraph(" Data "+date));
				//document.add(new Paragraph("\n"));
				
				 viagens.buscar(viagemSelecionada.getId());
				 
				 PdfPTable table1 = new PdfPTable(1);
				 table1.getDefaultCell().setBorder(Rectangle.NO_BORDER);

				 table1.addCell("Codigo "+viagemSelecionada.getId());
				 table1.setSpacingAfter(30);
				 table1.setTotalWidth(new float[]{440});
				 table1.setLockedWidth(true);
				 
				 PdfPTable table2 = new PdfPTable(3);
				 table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
				 
				 table2.addCell("Data : "+new SimpleDateFormat("dd/MM/yyyy").format(viagemSelecionada.getData()));
				 table2.addCell("Horário : "+viagemSelecionada.getHorario());
				 table2.addCell("Destino : "+viagemSelecionada.getDestino());
				 table2.setTotalWidth(new float[]{140,100,200});
				 table2.setLockedWidth(true);
				 table2.setSpacingAfter(15);
				 
				 PdfPTable table3 = new PdfPTable(2);
				 table3.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
				 table3.setSpacingAfter(20);
				 table3.setTotalWidth(new float[]{140,300});
				 table3.setLockedWidth(true);
				 
				 table3.addCell("valor : "+NumberFormat.getCurrencyInstance().format(viagemSelecionada.getValor()));
				 table3.addCell("Nome Cliente : "+viagemSelecionada.getCliente().getNome());
				 
				 PdfPTable table4 = new PdfPTable(1);
				 table4.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
				 table4.setSpacingAfter(20);
				 table4.setTotalWidth(new float[]{440});
				 table4.setLockedWidth(true);
				 
				 table4.addCell("Número Veículo : "+viagemSelecionada.getVeiculo().getNumero());
				 
				 PdfPTable table5 = new PdfPTable(1);
				 table5.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
				 table5.setTotalWidth(new float[]{440});
				 table5.setLockedWidth(true);
				 
				 table5.addCell("Motorista : "+viagemSelecionada.getFuncionario().getNome());
				 table5.setSpacingAfter(50);
				 
				 PdfPTable table6 = new PdfPTable(3);
				 table6.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
				 table6.setTotalWidth(new float[]{100,240,100});
				 table6.setLockedWidth(true);
				 
				 table6.addCell("");
				 table6.addCell("_________________________________");
				 table6.addCell("");
				 
				 PdfPTable table7 = new PdfPTable(3);
				 table7.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
				 table7.setTotalWidth(new float[]{260,240,100});
				 table7.setLockedWidth(true);
				 
				 table7.addCell("");
				 table7.addCell("Assinatura");
				 table7.addCell("");
				 table7.setSpacingAfter(50);
				 
				 PdfPTable table8 = new PdfPTable(1);
				 table8.getDefaultCell().setBorder(Rectangle.NO_BORDER); 
				 //table7.setSpacingAfter(40);
				 table8.setTotalWidth(new float[]{440});
				 table8.setLockedWidth(true);
				 
				 table8.addCell("Data de Impressão "+date);
				 //document.add(new Paragraph("Codigo da Viagem : "+viagemSelecionada.getId()));
				 //document.add(new Paragraph("Horário de Saída : "+viagemSelecionada.getHorario()));
				 //document.add(new Paragraph("Destino : "+viagemSelecionada.getDestino()));
				 //document.add(new Paragraph("Nome do Cliente : "+viagemSelecionada.getCliente().getNome()));
				 //document.add(new Paragraph("Valor : "+NumberFormat.getCurrencyInstance().format(viagemSelecionada.getValor())));
				 //document.add(new Paragraph("Número do Veículo : "+viagemSelecionada.getVeiculo().getNumero()));
				 //document.add(new Paragraph("Nome Funcionário : "+viagemSelecionada.getFuncionario().getNome()));
				
				 document.add(table1);
				 document.add(table2);
				 document.add(table3);
				 document.add(table4);
				 document.add(table5);
				 document.add(table6);
				 document.add(table7);
				 document.add(table8);
				//PdfPCell cell = new PdfPCell(new Paragraph("Lista de Veiculos ", FontFactory.getFont("Arial",//fonte
					//	8, //tamanho
					//	Font.BOLD, // estilo
					//	BaseColor.MAGENTA
					//	)));
				//PdfPCell header = new PdfPCell(new Paragraph("Algumas Palavaras Reservadas do Java"));
				
				//cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				//cell.setBackgroundColor(BaseColor.GRAY);
				//cell.setColspan(6);
				
				//table.addCell(cell);
				
				//cell = new PdfPCell(new Paragraph("ID", FontFactory.getFont("Arial",8,Font.BOLD,BaseColor.GRAY)));
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			document.close();
			
			FacesContext context = FacesContext.getCurrentInstance();
			Object response = context.getExternalContext().getResponse();
			
			if(response instanceof HttpServletResponse){
				HttpServletResponse hsr = (HttpServletResponse) response;
				hsr.setContentType("application/pdf");
				hsr.setHeader("Content-disposition", "attachment");
				hsr.setContentLength(baos.size());
				
				try{
					
					ServletOutputStream out = hsr.getOutputStream();
					baos.writeTo(out);
					out.flush();
				}catch(IOException io){
					System.out.println(io.getMessage());
				}
				
				context.responseComplete();
			}
		}


}
