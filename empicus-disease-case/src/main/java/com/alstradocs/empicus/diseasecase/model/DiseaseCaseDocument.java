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

import com.cloderia.enterprise.core.model.ArtifactData;
import com.cloderia.enterprise.core.model.ArtifactFieldData;
import com.cloderia.enterprise.core.model.BaseEntity;
import com.cloderia.enterprise.core.model.EntityStatus;
import com.cloderia.enterprise.document.model.Document;

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="DISEASE_CASE_DOCUMENT")
public class DiseaseCaseDocument extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "DiseaseCaseDocument";
    private DiseaseCase caseId;
    private Document documentId;
    private EntityStatus statusId;
	@NotNull(message="The description is required.")
	private String description;

    public DiseaseCaseDocument() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CASE_ID", nullable=false)
    public DiseaseCase getCaseId() {
        return this.caseId;
    }
    
    public void setCaseId(DiseaseCase caseId) {
        this.caseId = caseId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="DOCUMENT_ID", nullable=true)
    public Document getDocumentId() {
        return this.documentId;
    }
    
    public void setDocumentId(Document documentId) {
        this.documentId = documentId;
    }
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="STATUS_ID", nullable=false)
    public EntityStatus getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(EntityStatus statusId) {
        this.statusId = statusId;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDescription()
     */
    @Column(name="DESCRIPTION", nullable=false, length=255)
    public String getDescription() {
        return this.description;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setDescription(java.lang.String)
     */
    public void setDescription(String description) {
        this.description = description;
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
		entityDataInstance.getFieldData().put("caseId", new ArtifactFieldData("caseId", "DiseaseCase", true, getCaseId()));
		entityDataInstance.getFieldData().put("documentId", new ArtifactFieldData("documentId", "Document", true, getDocumentId()));
		entityDataInstance.getFieldData().put("statusId", new ArtifactFieldData("statusId", "EntityStatus", true, getStatusId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("description", new ArtifactFieldData("description", "Text", false, getDescription()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


