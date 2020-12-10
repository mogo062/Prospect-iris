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

public class T24FieldMetadataResourceState extends CollectionResourceState implements LazyResourceLoader {
    
    private ResourceFactory factory = null;

    public T24FieldMetadataResourceState() {
        this(new ResourceFactory());
    }

    public T24FieldMetadataResourceState(ResourceFactory factory) {
        super("T24FieldMetadata", "T24FieldMetadata", createActions(), "/{companyid}/T24FieldMetadata()", createLinkRelations(), null, null);
        this.factory = factory;
    }
    
    public boolean initialise() {
        Map<String, String> uriLinkageProperties = new HashMap<String, String>();
        List<Expression> conditionalLinkExpressions = null;
        CollectionResourceState sT24FieldMetadata = this;
        // create transitions
        return true;
    }
    
    private static List<Action> createActions() {
        Properties actionViewProperties = null;
        List<Action> T24FieldMetadataActions = new ArrayList<Action>();
        actionViewProperties = new Properties();
        T24FieldMetadataActions.add(new Action("T24FieldMetadata", Action.TYPE.ENTRY, actionViewProperties));
        return T24FieldMetadataActions;
    }

    private static String[] createLinkRelations() {
        String T24FieldMetadataRelationsStr = "";
        T24FieldMetadataRelationsStr += "http://temenostech.temenos.com/rels/metadata ";
        String[] T24FieldMetadataRelations = T24FieldMetadataRelationsStr.trim().split(" ");
        return T24FieldMetadataRelations;
    }
    
}
