/**
 * 
 */
package com.alstradocs.empicus.refdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;


/**
 * @author Edward Banfa
 */
@Entity
@Table(name="DISEASE_PHASE")
public class DiseasePhase extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "DiseasePhase";
	@NotNull(message="The instructions is required.")
	private String instructions;

    public DiseasePhase() {
    }
	
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getInstructions()
     */
    @Column(name="INSTRUCTIONS", nullable=false, length=255)
    public String getInstructions() {
        return this.instructions;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setInstructions(java.lang.String)
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

	@Transient
	public String getArtifactName() {
		return ARTIFACT_NAME;
	}
	
	/**
	 * @return
	 */
	public ArtifactData toEntityData(){
		ArtifactData entityDataInstance = new ArtifactData();
		entityDataInstance.setArtifactName(ARTIFACT_NAME);
		entityDataInstance.getFieldData().put("id", new ArtifactFieldData("id", "java.long.String", false, getId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("instructions", new ArtifactFieldData("instructions", "Text", false, getInstructions()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


