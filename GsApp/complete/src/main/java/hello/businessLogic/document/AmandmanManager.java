package hello.businessLogic.document;

import com.marklogic.client.document.DocumentUriTemplate;
import hello.StringResources.MarkLogicStrings;
import hello.businessLogic.core.BeanManager;
import hello.entity.gov.gradskaskupstina.Amandman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by milan on 5.6.2016..
 * Class that handles all amendment related operations.
 */
public class AmandmanManager extends BeanManager<Amandman> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Initializes a new intance of AmandmanManager. Uses schema in schema/Amandmani.xsd
     */
    public AmandmanManager(){
        super("schema/Amandmani.xsd");
    }

    /**
     * Returns all amendments that are proposed from database.
     * @return List of amendments in database. <code>NULL</code> if not successful.
     */
    public ArrayList<Amandman> getAllAmendmentProposed(){
        StringBuilder query = new StringBuilder();
        query.append("fn:collection(\"");
        query.append(MarkLogicStrings.AMANDMANI_PREDLOZEN_COL_ID);
        query.append("\")");
        return queryManager.executeQuery(query.toString());
    }

    /**
     * Return all amendments that are approved from database.
     * @return List of amendments in database. <code>NULL</code> if not successful.
     */
    public ArrayList<Amandman> getAllAmendmentsApproved(){
        StringBuilder query = new StringBuilder();
        query.append("fn:collection(\"");
        query.append(MarkLogicStrings.AMANDMANI_USVOJENI_COL_ID);
        query.append("\")");
        return queryManager.executeQuery(query.toString());
    }

    /**
     * Proposes an document.
     * @param amandman Bean to be proposed.
     * @return Generated URI. <code>NULL</code> if not successful.
     */
    public String proposeAmandman(Amandman amandman){

        if (!validateBeanBySchema(amandman)){
            logger.info("[AmandmanManager] ERROR: Amandman is not valid!");
            return null;
        }
        String ret = null;
        DocumentUriTemplate template = xmlManager.newDocumentUriTemplate("xml");
        try {
            ret = this.write(amandman,MarkLogicStrings.AMANDMANI_PREDLOZEN_COL_ID).getUri();
            amandman.setDocumentId(ret);
            if (!this.write(amandman,ret,MarkLogicStrings.AMANDMANI_PREDLOZEN_COL_ID)){
                ret = null;
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("[AmandmanManager] Could not propose Amandman!");
        }
        return ret;
    }

    /**
     * Approves an document.
     * @param amandman Bean to be approved.
     * @return Generated URI. <code>NULL</code> if not successful.
     */
    public String approveAmandman(Amandman amandman){
        if (!validateBeanBySchema(amandman)){
            logger.info("[AmandmanManager] ERROR: amendments is not valid!");
            return null;
        }
        String ret = null;
        String docId = amandman.getDocumentId();
        try {
            if (docId == null ||docId.isEmpty()){
                throw new Exception();
            }
            if (!this.deleteDocument(docId)) {
                throw  new Exception();
            }
        } catch (Exception e) {
            logger.error("[AmandmanManager] Could not delete amendments with id [" + docId + "] from proposed!");
        }
        try {
            if (!write(amandman,amandman.getDocumentId(),MarkLogicStrings.AMANDMANI_USVOJENI_COL_ID)){
                ret = null;
                throw  new Exception();
            } else {
                ret = amandman.getDocumentId();
            }

        } catch (Exception e) {
            logger.error("[AmandmanManager] Could not approve amendments!");
        }
        return ret;
    }

    /**
     * Deletes unapproved amendments.
     * @param docId URI of act to be deleted.
     * @return Indicator of success.
     */
    public boolean deleteAmandman(String docId){
        boolean ret = false;

        try {
            deleteDocument(docId);
            ret = true;
        } catch (Exception e){
            logger.error("[AmandmanManager] Could not delete document with id " + docId);
        }
        return ret;
    }

    /**
     * Validates amendments by schema.
     * @param amandman Amendment to be validated.
     * @return Indicator of success.
     */
    public boolean validateAkt(Amandman amandman){
        return validateBeanBySchema(amandman);
    }

}