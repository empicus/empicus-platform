/**
 * 
 */
package com.alstradocs.empicus.diseasecase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.alstradocs.empicus.refdata.model.AfterEffect;
import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="AFTER_EFFECT_OCCURANCE")
public class AfterEffectOccurance extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "AfterEffectOccurance";
    private AfterEffect effectId;
    private DiseaseCase caseId;
	@NotNull(message="The instructions is required.")
	private String instructions;

    public AfterEffectOccurance() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="EFFECT_ID", nullable=false)
    public AfterEffect getEffectId() {
        return this.effectId;
    }
    
    public void setEffectId(AfterEffect effectId) {
        this.effectId = effectId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CASE_ID", nullable=true)
    public DiseaseCase getCaseId() {
        return this.caseId;
    }
    
    public void setCaseId(DiseaseCase caseId) {
        this.caseId = caseId;
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
		entityDataInstance.getFieldData().put("effectId", new ArtifactFieldData("effectId", "AfterEffect", true, getEffectId()));
		entityDataInstance.getFieldData().put("caseId", new ArtifactFieldData("caseId", "DiseaseCase", true, getCaseId()));
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


