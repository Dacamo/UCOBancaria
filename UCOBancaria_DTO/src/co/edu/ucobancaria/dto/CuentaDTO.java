package co.edu.ucobancaria.dto;

/**
 * Objeto de transferencia de datos que representa a una cuenta
 */

public  final class CuentaDTO {
	
	private int codigo;
	private MovimientoDTO movimiento;
	private String numero;
	private TipoCuentaDTO tipoCuenta;
	private double saldo;
	
	public CuentaDTO () {
		super();
	}
	
	public CuentaDTO(int codigo, MovimientoDTO movimiento, String numero, TipoCuentaDTO tipoCuenta, double saldo) {
		super();
		setCodigo(codigo);
		setMovimiento(movimiento);
		setNumero(numero);
		setTipoCuenta(tipoCuenta);
		setSaldo(saldo);
	}


	public final int getCodigo() {
		return codigo;
	}


	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public final MovimientoDTO getMovimiento() {
		return movimiento;
	}


	public final void setMovimiento(MovimientoDTO movimiento) {
		this.movimiento = movimiento;
	}


	public final String getNumero() {
		return numero;
	}


	public final void setNumero(String numero) {
		this.numero = numero;
	}


	public final TipoCuentaDTO getTipoCuenta() {
		return tipoCuenta;
	}


	public final void setTipoCuenta(TipoCuentaDTO tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}


	public final double getSaldo() {
		return saldo;
	}


	public final void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
}
