package br.com.fsales.parktech.adapters.out.repository.mapper;

//@Mapper(componentModel = "spring")
public abstract class VeiculoEntityMapperDecorator /* implements VeiculoEntityMapper */ {

	// @Autowired
	// @Qualifier("veiculoEntityMapperImpl_")
	// private VeiculoEntityMapper delegate;
	//
	// @Override
	// public void updateVeiculoEntityFromVeiculo(Veiculo veiculo, VeiculoEntity
	// veiculoEntity) {
	// var condutor = veiculoEntity.getCondutor();
	// veiculoEntity.setMarca(veiculo.marca());
	// veiculoEntity.setModelo(veiculo.modelo());
	// veiculoEntity.setPlaca(veiculo.placa());
	// veiculoEntity.setRenavam(veiculo.renavam());
	// }
	//
	// @Override
	// public CondutorEntity condutorToCondutorEntity(Condutor condutor) {
	//
	// return CondutorEntityMapperDecorator.criarObjetoCondutorEntity(condutor);
	// }
	//
	// @Override
	// public Condutor condutorEntityToCondutor(CondutorEntity condutorEntity) {
	//
	// return CondutorEntityMapperDecorator.criarObjetoConduto(condutorEntity);
	// }
	//
	// @Override
	// public VeiculoEntity toVeiculoEntity(Veiculo veiculo) {
	// var veiculoEntity = delegate.toVeiculoEntity(veiculo);
	// veiculoEntity.setModelo(veiculo.modelo());
	// veiculoEntity.setPlaca(veiculo.placa());
	// veiculoEntity.setRenavam(veiculo.renavam());
	// veiculoEntity.setMarca(veiculo.marca());
	// veiculoEntity.setId(veiculo.id());
	// veiculoEntity.setCondutor(condutorToCondutorEntity(veiculo.condutor()));
	//
	// return veiculoEntity;
	// }
	//
	// @Override
	// public Veiculo toVeiculo(VeiculoEntity veiculoEntity) {
	// var veiculo = delegate.toVeiculo(veiculoEntity);
	//
	//// veiculo.setModelo(veiculoEntity.getModelo());
	//// veiculo.setPlaca(veiculoEntity.getPlaca());
	//// veiculo.setRenavam(veiculoEntity.getRenavam());
	//// veiculo.setMarca(veiculoEntity.getMarca());
	//// veiculo.setId(veiculoEntity.getId());
	//// veiculo.setCondutor(condutorEntityToCondutor(veiculoEntity.getCondutor()));
	// return veiculo;
	// }

}
