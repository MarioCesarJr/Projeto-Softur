package softur.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import softur.entities.Veiculo;
import softur.repository.Veiculos;
import softur.service.GestaoVeiculos;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@ManagedBean(name="consultaVeiculoBean")
public class ConsultaVeiculoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Veiculo> veiculoList = new ArrayList<Veiculo>();
	private Veiculo veiculoSelecionado;

	public ConsultaVeiculoBean(){
		
	}
	
	@PostConstruct
	public void init() {
		Veiculos veiculos = new Veiculos();
		this.veiculoList = veiculos.listarTodos();
	}

	public String excluir() {
		GestaoVeiculos gestaoVeiculos = new GestaoVeiculos();
		gestaoVeiculos.excluir(this.veiculoSelecionado);
		this.init();
		return "";
	}

	public List<Veiculo> getVeiculoList() {
		return veiculoList;
	}

	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}

	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}
	
    public void imprimir(){
			
			Document document = new Document(PageSize.A4);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			try{
				
				PdfWriter.getInstance(document, baos);
				
				
				Veiculos veiculos = new Veiculos();
				List<Veiculo> veiculoList = veiculos.listarTodos();
				
				document.open();
				
				//document.add(new Paragraph(" TOTAL DE VEICULOS \n \n"));
				
				Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
				
				Paragraph p = new Paragraph("Total de Veículos",f);
				p.setAlignment(Element.ALIGN_CENTER);
				p.setSpacingAfter(20);
				document.add(p);
				
				
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date currentDate = new Date();
				String date = formatter.format(currentDate);
				//document.add(new Paragraph(" Data "+date));
				//document.add(new Paragraph("\n"));
				
				
				PdfPTable table = new PdfPTable(9);
				
				table.setTotalWidth(new float[]{50,50,90,90,53,90,60,60,42});
				table.setLockedWidth(true);
				
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
				
				table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);;
				
				table.addCell("Codigo");
				table.addCell("veículo");
				table.addCell("marca");
				table.addCell("modelo");
				table.addCell("placa");
				table.addCell("chassi");
				table.addCell("Poltronas");
				table.addCell("Banheiro");
				table.addCell("Ano");
				
				for (int i = 0; i < veiculoList.size(); i++) {
				    Veiculo veiculo = veiculoList.get(i);
	                
				    table.getDefaultCell().setBackgroundColor(null);
				    
					table.addCell(veiculo.getId().toString());
					table.addCell(veiculo.getNumero());
					table.addCell(veiculo.getMarca());
					table.addCell(veiculo.getModelo());
					table.addCell(veiculo.getPlaca());
					table.addCell(veiculo.getChassi());
					table.addCell(veiculo.getPoltronas());
					table.addCell(veiculo.getBanheiro());
					table.addCell(veiculo.getAnoModelo());
				}
				
				document.add(table);
				document.add(new Paragraph(" Data "+date));
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
	

