package T24.enqAccountList;
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

public class enqAccountListsResourceState extends CollectionResourceState implements LazyResourceLoader {
    
    private ResourceFactory factory = null;

    public enqAccountListsResourceState() {
        this(new ResourceFactory());
    }

    public enqAccountListsResourceState(ResourceFactory factory) {
        super("enqAccountList", "enqAccountLists", createActions(), "/{companyid}/enqAccountLists()", createLinkRelations(), null, null);
        this.factory = factory;
    }
    
    public boolean initialise() {
        Map<String, String> uriLinkageProperties = new HashMap<String, String>();
        List<Expression> conditionalLinkExpressions = null;
        CollectionResourceState senqAccountLists = this;
        // create transitions
        ResourceState senqAccountList = factory.getResourceState("T24.enqAccountList.enqAccountList");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("id", "{Acc}");
            senqAccountLists.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(senqAccountList)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("enqAccountList")
                    .linkId("")
                    .sourceField("")
                    .build());



        ResourceState sT24_verAccount_verAccount_see = factory.getResourceState("T24.verAccount.verAccount_see");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("id", "{Acc}");
        uriLinkageProperties.put("t24Intent", "View");
            senqAccountLists.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_verAccount_verAccount_see)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Account details")
                    .linkId("1")
                    .sourceField("Acc")
                    .build());



        ResourceState sT24_verEbContractBalances_Ac_verEbContractBalances_Ac_see = factory.getResourceState("T24.verEbContractBalances_Ac.verEbContractBalances_Ac_see");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("id", "{Acc}");
        uriLinkageProperties.put("t24Intent", "View");
            senqAccountLists.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_verEbContractBalances_Ac_verEbContractBalances_Ac_see)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Balance details")
                    .linkId("2")
                    .sourceField("Acc")
                    .build());



        ResourceState sT24_verCustomerAccount_verCustomerAccount_see = factory.getResourceState("T24.verCustomerAccount.verCustomerAccount_see");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("id", "{Customer}");
        uriLinkageProperties.put("t24Intent", "View");
            senqAccountLists.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(sT24_verCustomerAccount_verCustomerAccount_see)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("View ")
                    .linkId("3")
                    .sourceField("Customer")
                    .build());



        ResourceState senqAccountListByCustomer = factory.getResourceState("T24.enqAccountList.enqAccountListByCustomer");

        // create foreach transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("filter", "Customer eq '{Customer}'");
            senqAccountLists.addTransition(new Transition.Builder()
                    .flags(Transition.FOR_EACH)
                    .method("GET")
                    .target(senqAccountListByCustomer)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .label("Account List")
                    .linkId("4")
                    .sourceField("Customer")
                    .build());



        return true;
    }
    
    private static List<Action> createActions() {
        Properties actionViewProperties = null;
        List<Action> enqAccountListsActions = new ArrayList<Action>();
        return enqAccountListsActions;
    }

    private static String[] createLinkRelations() {
        String[] enqAccountListsRelations = null;
        return enqAccountListsRelations;
    }
    
}
