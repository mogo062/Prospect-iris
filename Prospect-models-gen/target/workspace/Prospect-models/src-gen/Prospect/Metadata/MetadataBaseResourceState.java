package Prospect.Metadata;
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

public class MetadataBaseResourceState extends ResourceState implements LazyResourceLoader {
    
    private ResourceFactory factory = null;

    public MetadataBaseResourceState() {
        this(new ResourceFactory());
    }

    public MetadataBaseResourceState(ResourceFactory factory) {
        super("Metadata", "MetadataBase", createActions(), "/$metadata", createLinkRelations(), new UriSpecification("MetadataBase", "/$metadata"), null);
        setInitial(true);
        this.factory = factory;
    }
    
    public boolean initialise() {
        Map<String, String> uriLinkageProperties = new HashMap<String, String>();
        List<Expression> conditionalLinkExpressions = null;
        ResourceState sMetadataBase = this;
        // create transitions
        ResourceState sODataMetadata = factory.getResourceState("Prospect.Prospect.ODataMetadata");



        // create REDIRECT transition
            conditionalLinkExpressions = null;
            uriLinkageProperties.clear();
        uriLinkageProperties.put("companyid", "{DefaultCompany}");
            sMetadataBase.addTransition(new Transition.Builder()
                    .flags(Transition.REDIRECT)
                    .target(sODataMetadata)
                    .uriParameters(uriLinkageProperties)
                    .evaluation(conditionalLinkExpressions != null ? new SimpleLogicalExpressionEvaluator(conditionalLinkExpressions) : null)
                    .sourceField("")
                    .build());

        return true;
    }
    
    private static List<Action> createActions() {
        Properties actionViewProperties = null;
        List<Action> MetadataBaseActions = new ArrayList<Action>();
        MetadataBaseActions.add(new Action("GETMetadata", Action.TYPE.VIEW, new Properties()));
        return MetadataBaseActions;
    }

    private static String[] createLinkRelations() {
        String[] MetadataBaseRelations = null;
        return MetadataBaseRelations;
    }
    
}
