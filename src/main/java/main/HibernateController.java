package main;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import proyectohibernate.Habitaciones;
import proyectohibernate.HabitacionesObservaciones;
import proyectohibernate.HibernateUtil;
import proyectohibernate.Hoteles;
import proyectohibernate.Estancias;
import proyectohibernate.Regimenes;
import proyectohibernate.Clientes;
import javafx.fxml.Initializable;

public class HibernateController implements Initializable {
	int modificar;
	ObservableList<Habitaciones> habitacionesList = FXCollections.observableArrayList();
	ObservableList<Hoteles> hotelesList = FXCollections.observableArrayList();
	
	
	@FXML
	private TableView<Habitaciones> table1;

	@FXML
	private TableColumn<Habitaciones, String> codigoColumn1;

	@FXML
	private TableColumn<Habitaciones, String> hotelColumn1;

	@FXML
	private TableColumn<Habitaciones, String> numeroColumn1;

	@FXML
	private TableColumn<Habitaciones, String> capacidadColumn1;

	@FXML
	private TableColumn<Habitaciones, Boolean> activaColumn1;

	@FXML
	private TableColumn<Habitaciones, String> precioColumn1;

	@FXML
	private TableColumn<Habitaciones, String> observacionesColumn1;

    @FXML
    private TabPane view;

	@FXML
    private Tab Estancias;

    @FXML
    private Tab Habitacion;

    @FXML
    private CheckBox activabox;

    @FXML
    private TextField capacidadtext1;

    @FXML
    private TextField codDni;
    
    @FXML
    private TextField codDni5;

    @FXML
    private TextField codEstancia;

    @FXML
    private TextField codHabitacion;

    @FXML
    private TextField codHoteltext1;

    @FXML
    private TextField codRegimen;

    @FXML
    private TextField fechaFin;

    @FXML
    private TextField fechaInicio;

    @FXML
    private TextField nomHoteltext1;
    
    @FXML
    private TextField nombre;
    
    @FXML
    private TextField nacionalidad;

    @FXML
    private TextField numHabtext1;

    @FXML
    private TextField ocupantes;

    @FXML
    private TextField precioEstancia;

    @FXML
    private TextField preciodiatext1;

    @FXML
    private TextField preciodiatext2;
    
    @FXML
    private TextField codHotel2;
    
    @FXML
    private TextField nomHotel4;
    
    @FXML
    private TextField codHotel4;

    @FXML
    private TextArea observacionestext1;

    @FXML
    private Button crearbutton1;
    
    @FXML
    private Button crearbutton2;

    @FXML
    private Button crearbutton3;

    @FXML
    private Button crearbutton4;
    
    @FXML
    private Button updatebutton1;

    @FXML
    private Button cargarbutton1;

    @FXML
    private Button borrarbutton1;
    
    @FXML
    private ComboBox<String> comboDietas;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		comboDietas.getItems().addAll("DY","MD","CN","TI");
		codigoColumn1.setCellValueFactory(v -> new SimpleStringProperty(v.getValue().getCodHabitacion()));
		hotelColumn1.setCellValueFactory(v -> new SimpleStringProperty(v.getValue().getHotelessobj().getCodHotel()));
		numeroColumn1.setCellValueFactory(new PropertyValueFactory<Habitaciones, String>("numHabitacion"));
		capacidadColumn1.setCellValueFactory(v -> new SimpleStringProperty(v.getValue().getCapacidad()));
		activaColumn1.setCellValueFactory(v -> new SimpleBooleanProperty(v.getValue().getActiva()));
		precioColumn1.setCellValueFactory(v -> new SimpleStringProperty(v.getValue().getPrecioDia()));
		observacionesColumn1.setCellValueFactory(
				v -> new SimpleStringProperty(v.getValue().getHabitacionesobservaciones().getObservaciones()));

		activaColumn1.setCellFactory(CheckBoxTableCell.forTableColumn(activaColumn1));
		codigoColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		hotelColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		numeroColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		capacidadColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		precioColumn1.setCellFactory(TextFieldTableCell.forTableColumn());
		updatebutton1.setDisable(true);
		update();

	}

	public HibernateController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();

		crearbutton1.disableProperty().bind(codHoteltext1.textProperty().isEmpty());

	}

	public TabPane getView() {
		return view;
	}

	public void update() {
		Session sesion = HibernateUtil.getCurrentSession();
		Query query = sesion.createQuery("FROM Habitaciones");
		ArrayList<Habitaciones> habitaciones = (ArrayList<Habitaciones>) query.list();
		habitacionesList = FXCollections.observableArrayList(habitaciones);
		table1.setItems(habitacionesList);
		sesion.close();
	}

	@FXML
	void onClickCrear1(ActionEvent event) {
		Session sesion = HibernateUtil.getCurrentSession();
		Habitaciones creada = new Habitaciones();
		Hoteles hotelesobj = new Hoteles();
		HabitacionesObservaciones ho = new HabitacionesObservaciones();
		hotelesobj.setCodHotel(codHoteltext1.getText());
		hotelesobj.setNomHotel(nomHoteltext1.getText());
		creada.setHotelesobj(hotelesobj);
		creada.setActiva(activabox.isSelected());
		creada.setNumHabitacion(codHoteltext1.getText());
		creada.setCapacidad(Integer.parseInt(capacidadtext1.getText()));
		creada.setPrecioDia(Integer.parseInt(preciodiatext1.getText()));

		if (observacionestext1.getText() != "") {
			ho.setObservaciones(observacionestext1.getText());
			ho.setCodHabitacionesXXX(creada);
			creada.setHabitacionesobservaciones(ho);
		} else
			creada.setHabitacionesobservaciones(null);
		sesion.beginTransaction();
		sesion.saveOrUpdate(hotelesobj);
		sesion.save(creada);
		sesion.getTransaction().commit();
		sesion.close();
		update();
	}

	@FXML
	void onClickBorrar1(ActionEvent event) {
		Session sesion = HibernateUtil.getCurrentSession();
		int borrar;
		borrar = Integer.parseInt(table1.getSelectionModel().getSelectedItem().getCodHabitacion());
		Habitaciones borrada = new Habitaciones();
		borrada.setCodHabitacion(borrar);
		sesion.beginTransaction();
		sesion.delete(borrada);
		sesion.getTransaction().commit();
		sesion.close();
		update();
	}

	@FXML
	void onClickUpdate1(ActionEvent event) {
		Session sesion = HibernateUtil.getCurrentSession();
		Habitaciones modificada = new Habitaciones();
		Hoteles hotelesobj = new Hoteles();
		HabitacionesObservaciones ho = new HabitacionesObservaciones();
		hotelesobj.setCodHotel(codHoteltext1.getText());
		hotelesobj.setNomHotel(nomHoteltext1.getText());
		modificada.setHotelesobj(hotelesobj);
		modificada.setActiva(activabox.isSelected());
		modificada.setNumHabitacion(codHoteltext1.getText());
		modificada.setCapacidad(Integer.parseInt(capacidadtext1.getText()));
		modificada.setPrecioDia(Integer.parseInt(preciodiatext1.getText()));
		modificada.setCodHabitacion(modificar);
		ho.setCodHabitaciones(modificar);
		ho.setObservaciones(observacionestext1.getText());
		modificada.setHabitacionesobservaciones(ho);
		sesion.beginTransaction();

		sesion.update(modificada);
		sesion.update(ho);
		sesion.flush();
		sesion.getTransaction().commit();
		sesion.close();
		clear();
		update();
	}

	public void clear() {
		codHoteltext1.setText("");
		nomHoteltext1.setText("");
		activabox.selectedProperty().set(false);
		numHabtext1.setText("");
		capacidadtext1.setText("");
		preciodiatext1.setText("");
		this.modificar = -1;
		updatebutton1.setDisable(true);
	}

	@FXML
	void onClickCargar1(ActionEvent event) {
		Session sesion = HibernateUtil.getCurrentSession();
		codHoteltext1.setText(table1.getSelectionModel().getSelectedItem().getHotelessobj().getCodHotel());
		nomHoteltext1.setText(table1.getSelectionModel().getSelectedItem().getHotelessobj().getNomHotel());
		activabox.selectedProperty().set(table1.getSelectionModel().getSelectedItem().getActiva());
		numHabtext1.setText(table1.getSelectionModel().getSelectedItem().getNumHabitacion());
		capacidadtext1.setText(table1.getSelectionModel().getSelectedItem().getCapacidad());
		preciodiatext1.setText(table1.getSelectionModel().getSelectedItem().getPrecioDia());
		observacionestext1.setText(
				table1.getSelectionModel().getSelectedItem().getHabitacionesobservaciones().getObservaciones());
		this.modificar = Integer.parseInt(table1.getSelectionModel().getSelectedItem().getCodHabitacion());
		updatebutton1.setDisable(false);
		/*
		 * modificada.setNumHabitacion(codHoteltext1.getText());
		 * modificada.setCapacidad(Integer.parseInt(capacidadtext1.getText()));
		 * modificada.setPrecioDia(Integer.parseInt(preciodiatext1.getText()));
		 * modificada.setHotelesobj(hotelesobj);
		 */
		sesion.close();
		update();
	}
	
	  @FXML
	    void onClickCrear2(ActionEvent event) {
		  Session sesion = HibernateUtil.getCurrentSession();
			Estancias creada = new Estancias();
			Regimenes regimenesobj = new Regimenes();
			Habitaciones hab= new Habitaciones();
			Clientes cliente= new Clientes();
			regimenesobj.setCodregimen(Integer.parseInt( codRegimen.getText()));
			cliente.setCodDNIoNIE(codDni.getText());
			hab.setCodHabitacion(Integer.parseInt( codHabitacion.getText()));
			creada.setClientesobj(cliente);
			creada.setFechaFin(fechaFin.getText());
			creada.setFechaInicio(fechaInicio.getText());
			creada.setHabitacionesobj(hab);
			creada.setRegimenesobj(regimenesobj);
			creada.setPrecioEstancia(Integer.parseInt( precioEstancia.getText()));
			creada.setPagado(activabox.isSelected());
			creada.setOcupantes(Integer.parseInt(ocupantes.getText()));
			sesion.beginTransaction();
			sesion.saveOrUpdate(regimenesobj);
			sesion.saveOrUpdate(hab);
			sesion.saveOrUpdate(cliente);
			sesion.save(creada);
			sesion.getTransaction().commit();
			sesion.close();
			
	    }
	  @FXML
	    void onClickCrear3(ActionEvent event) {
		  Session sesion = HibernateUtil.getCurrentSession();
			Regimenes creada = new Regimenes();
			Hoteles hotelesobj = new Hoteles();
			hotelesobj.setCodHotel(codHotel2.getText());
			creada.setHotelesobj(hotelesobj);
			creada.setTipo(comboDietas.getValue());
			creada.setPrecioDia(Integer.parseInt( preciodiatext2.getText()));
			sesion.beginTransaction();
			sesion.saveOrUpdate(hotelesobj);
			sesion.save(creada);
			sesion.getTransaction().commit();
			sesion.close();
		  
	  }
	  @FXML
	    void onClickCrear4(ActionEvent event) {
		  Session sesion = HibernateUtil.getCurrentSession();
			Hoteles creada = new Hoteles();
			creada.setNomHotel(nomHotel4.getText());
			creada.setCodHotel(codHotel4.getText());
			sesion.beginTransaction();
			sesion.save(creada);
			sesion.getTransaction().commit();
			sesion.close();
		  
	  }
	  @FXML
	    void onClickCrear5(ActionEvent event) {
		  Session sesion = HibernateUtil.getCurrentSession();
			Clientes creada = new Clientes();
			creada.setCodDNIoNIE(codDni5.getText());
			creada.setNacionalidad(nacionalidad.getText());
			creada.setNombre(nombre.getText());
			sesion.beginTransaction();
			sesion.save(creada);
			sesion.getTransaction().commit();
			sesion.close();
	  }
	  
	  public ObservableList<Habitaciones> getHabitacionesList() {
			return habitacionesList;
		}

		public void addHotelesList(Hoteles hoteles) {
			this.hotelesList.add(hoteles);
		}

		public ObservableList<Hoteles> getHotelesList() {
			return hotelesList;
		}

		public void addHabitacionesList(Habitaciones habitaciones) {
			this.habitacionesList.add(habitaciones);
		}
}
