library Rule version '0.1.0'
using FHIR version '4.0.0'
include FHIRHelpers version '4.0.0' called FHIRHelpers

parameter Patient Patient
parameter device_request DeviceRequest

define "Age":
  AgeInYears()

define "Gender":
  Patient.gender.value

define "PatientHomeState":
  Patient.address.where(use.value = 'home')[0].state.value

define RULE_APPLIES:
  "Age" > 0

define RESULT_Summary:
  'No auth needed'

define RESULT_Details:
  'No authorization is required, as laid out at the attached link.'

define RESULT_InfoLink:
    'https://www.cms.gov/outreach-and-education/medicare-learning-network-mln/mlnproducts/downloads/home-oxygen-therapy-text-only.pdf'

define RESULT_QuestionnaireUri:
    'urn:hl7:davinci:crd:home-oxygen-questionnaire_2-r4'

define RESULT_requestId:
  device_request
