package T24.enqCustomer;
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

public class enqCustomersResourceState extends CollectionResourceState implements LazyResourceLoader {
    
    private ResourceFactory factory = null;

    public enqCustomersResourceState() {
        this(new ResourceFactory());
    }

    public enqCustomersResourceState(ResourceFactory factory) {
        super("enqCustomer", "enqCustomers", createActions(), "/{companyid}/enqCustomers()", createLinkRelations(), null, null);
        this.factory = factory;
    }
    
    public boolean initialise() {
        Map<String, String> uriLinkageProperties = new HashMap<String, String>();
        List<Expression> conditionalLinkExpressions = null;
        CollectionResourceState senqCustomers = this;
        // create transitions
        ResourceState senqCustomer = factory.getResourceState("T24.enqCustomer.enqCustomer");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("id", "{Id}");
            senqCustomers.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(senqCustomer)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("enqCustomer")
                    .linkId("")
                    .sourceField("")
                    .build());



        ResourceState sT24_verCustomer_verCustomer_see = factory.getResourceState("T24.verCustomer.verCustomer_see");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("id", "{Id}");
        uriLinkageProperties.put("t24Intent", "View");
            senqCustomers.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_verCustomer_verCustomer_see)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("View Record")
                    .linkId("1")
                    .sourceField("Id")
                    .build());



        ResourceState sT24_enqListLoans_enqListLoanss = factory.getResourceState("T24.enqListLoans.enqListLoanss");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("filter", "CustomerNo eq '{Id}'");
            senqCustomers.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_enqListLoans_enqListLoanss)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Primarily &amp; Jointly held Loans")
                    .linkId("2")
                    .sourceField("Id")
                    .build());



        ResourceState sT24_enqCustomerPositionSummary_enqCustomerPositionSummarys = factory.getResourceState("T24.enqCustomerPositionSummary.enqCustomerPositionSummarys");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("filter", "CustomerNo eq '{Id}'");
            senqCustomers.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_enqCustomerPositionSummary_enqCustomerPositionSummarys)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Customer Position Summary")
                    .linkId("3")
                    .sourceField("Id")
                    .build());



        ResourceState sT24_enqLiab_enqLiabs = factory.getResourceState("T24.enqLiab.enqLiabs");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("filter", "LiabilityNumber eq '{Id}'");
            senqCustomers.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_enqLiab_enqLiabs)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Customer Liability")
                    .linkId("4")
                    .sourceField("Id")
                    .build());



        return true;
    }
    
    private static List<Action> createActions() {
        Properties actionViewProperties = null;
        List<Action> enqCustomersActions = new ArrayList<Action>();
        return enqCustomersActions;
    }

    private static String[] createLinkRelations() {
        String[] enqCustomersRelations = null;
        return enqCustomersRelations;
    }
    
}
