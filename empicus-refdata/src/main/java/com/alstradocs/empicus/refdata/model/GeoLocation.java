/**
 * 
 */
package com.alstradocs.empicus.refdata.model;

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

/**
 * @author Edward Banfa
 */
@Entity
@Table(name="GEO_LOCATION")
public class GeoLocation extends BaseEntity {

	private static final long serialVersionUID = 1L;
    public static final String ARTIFACT_NAME = "GeoLocation";
    private GeoZone zoneId;
	@NotNull(message="The latitude is required.")
	private String latitude;
	@NotNull(message="The longitude is required.")
	private String longitude;
	private String description;

    public GeoLocation() {
    }
	
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ZONE_ID", nullable=false)
    public GeoZone getZoneId() {
        return this.zoneId;
    }
    
    public void setZoneId(GeoZone zoneId) {
        this.zoneId = zoneId;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getLatitude()
     */
    @Column(name="LATITUDE", nullable=false, length=75)
    public String getLatitude() {
        return this.latitude;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setLatitude(java.lang.String)
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getLongitude()
     */
    @Column(name="LONGITUDE", nullable=false, length=75)
    public String getLongitude() {
        return this.longitude;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#setLongitude(java.lang.String)
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    /* (non-Javadoc)
     * @see com.cloderia.alstracoin.core.data.BaseEntity#getDescription()
     */
    @Column(name="DESCRIPTION", nullable=true, length=150)
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
		entityDataInstance.getFieldData().put("zoneId", new ArtifactFieldData("zoneId", "GeoZone", true, getZoneId()));
		entityDataInstance.getFieldData().put("code", new ArtifactFieldData("code", "Code", false, getCode()));
		entityDataInstance.getFieldData().put("name", new ArtifactFieldData("name", "String", false, getName()));
		entityDataInstance.getFieldData().put("latitude", new ArtifactFieldData("latitude", "String", false, getLatitude()));
		entityDataInstance.getFieldData().put("longitude", new ArtifactFieldData("longitude", "String", false, getLongitude()));
		entityDataInstance.getFieldData().put("description", new ArtifactFieldData("description", "Text", false, getDescription()));
		entityDataInstance.getFieldData().put("status", new ArtifactFieldData("status", "String", false, getStatus()));
		entityDataInstance.getFieldData().put("createdDt", new ArtifactFieldData("createdDt", "Date", false, getCreatedDt()));
		entityDataInstance.getFieldData().put("createdByUsr", new ArtifactFieldData("createdByUsr", "Code", false, getCreatedByUsr()));
		entityDataInstance.getFieldData().put("lastModifiedDt", new ArtifactFieldData("lastModifiedDt", "Date", false, getLastModifiedDt()));
		entityDataInstance.getFieldData().put("lastModifiedUsr", new ArtifactFieldData("lastModifiedUsr", "Code", false, getLastModifiedUsr()));

		return entityDataInstance;
	}
}


