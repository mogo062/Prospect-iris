package Prospect.Prospect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.temenos.interaction.core.hypermedia.UriSpecification;
import com.temenos.interaction.core.hypermedia.Action;
import com.temenos.interaction.core.hypermedia.CollectionResourceState;
import com.temenos.interaction.core.hypermedia.DynamicResourceState;        
import com.temenos.interaction.core.hypermedia.LazyResourceLoader;        
import com.temenos.interaction.core.hypermedia.ResourceFactory;
import com.temenos.interaction.core.hypermedia.ResourceState;
import com.temenos.interaction.core.hypermedia.ResourceStateMachine;
import com.temenos.interaction.core.hypermedia.Transition;
import com.temenos.interaction.core.hypermedia.validation.HypermediaValidator;
import com.temenos.interaction.core.hypermedia.expression.Expression;
import com.temenos.interaction.core.hypermedia.expression.ResourceGETExpression;
import com.temenos.interaction.core.hypermedia.expression.SimpleLogicalExpressionEvaluator;
import com.temenos.interaction.core.hypermedia.ResourceLocator;        
import com.temenos.interaction.core.hypermedia.ResourceLocatorProvider;

public class ServiceDocumentResourceState extends ResourceState implements LazyResourceLoader {
    
    private ResourceFactory factory = null;

    public ServiceDocumentResourceState() {
        this(new ResourceFactory());
    }

    public ServiceDocumentResourceState(ResourceFactory factory) {
        super("ServiceDocument", "ServiceDocument", createActions(), "/{companyid}/", createLinkRelations(), new UriSpecification("ServiceDocument", "/{companyid}/"), null);
        setInitial(true);
        this.factory = factory;
    }
    
    public boolean initialise() {
        Map<String, String> uriLinkageProperties = new HashMap<String, String>();
        List<Expression> conditionalLinkExpressions = null;
        ResourceState sServiceDocument = this;
        // create transitions
        ResourceState sT24FieldMetadata = factory.getResourceState("Prospect.Prospect.T24FieldMetadata");
        // create regular transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
            sServiceDocument.addTransition(new Transition.Builder()
                    .method("GET")
                    .target(sT24FieldMetadata)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("T24FieldMetadata")
                    .sourceField("")
                    .build());




        ResourceState senqCustomer = factory.getResourceState("T24.enqCustomer.enqCustomer");
        // create regular transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
            sServiceDocument.addTransition(new Transition.Builder()
                    .method("GET")
                    .target(senqCustomer)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("enqCustomer")
                    .sourceField("")
                    .build());




        ResourceState senqAccountList = factory.getResourceState("T24.enqAccountList.enqAccountList");
        // create regular transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
            sServiceDocument.addTransition(new Transition.Builder()
                    .method("GET")
                    .target(senqAccountList)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("enqAccountList")
                    .sourceField("")
                    .build());




        ResourceState senqAccountListByCustomer = factory.getResourceState("T24.enqAccountList.enqAccountListByCustomer");
        // create regular transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
            sServiceDocument.addTransition(new Transition.Builder()
                    .method("GET")
                    .target(senqAccountListByCustomer)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("enqAccountListByCustomer")
                    .sourceField("")
                    .build());




        ResourceState sErrors = factory.getResourceState("common.Errors.Errors");
        // create regular transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
            sServiceDocument.addTransition(new Transition.Builder()
                    .method("GET")
                    .target(sErrors)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Errors")
                    .sourceField("")
                    .build());




        return true;
    }
    
    private static List<Action> createActions() {
        Properties actionViewProperties = null;
        List<Action> ServiceDocumentActions = new ArrayList<Action>();
        ServiceDocumentActions.add(new Action("GETServiceDocument", Action.TYPE.VIEW, new Properties()));
        return ServiceDocumentActions;
    }

    private static String[] createLinkRelations() {
        String[] ServiceDocumentRelations = null;
        return ServiceDocumentRelations;
    }
    
}
