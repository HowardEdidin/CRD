package org.hl7.davinci.stu3.crdhook.orderselect;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.validation.constraints.NotNull;
import org.hl7.davinci.stu3.JacksonBundleDeserializer;
import org.hl7.davinci.stu3.JacksonHapiSerializer;
import org.hl7.davinci.stu3.crdhook.ServiceContext;
import org.hl7.fhir.dstu3.model.Bundle;

public class OrderSelectContext extends ServiceContext {

  /** The FHIR Patient.id of the current patient in context. REQUIRED */
  @NotNull
  private String patientId;

  /** The FHIR Encounter.id of the current encounter in context. OPTIONAL */
  private String encounterId;

  /** The FHIR id of the newly selected order(s). The selections field references FHIR resources
   * in the draftOrders Bundle. For example, MedicationRequest/103. */
  private String[] selections;


  /**
   * STU3 - FHIR Bundle of MedicationRequest, ReferralRequest, ProcedureRequest, NutritionOrder,
   * VisionPrescription. REQUIRED
   */
  @JsonSerialize(using = JacksonHapiSerializer.class)
  @JsonDeserialize(using = JacksonBundleDeserializer.class)
  private Bundle draftOrders;

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getEncounterId() {
    return encounterId;
  }

  public void setEncounterId(String encounterId) {
    this.encounterId = encounterId;
  }

  public String[] getSelections() { return selections; }

  public void setSelections(String[] selections) { this.selections = selections; }

  public Bundle getDraftOrders() {
    return draftOrders;
  }

  public void setDraftOrders(Bundle draftOrders) {
    this.draftOrders = draftOrders;
  }

}
