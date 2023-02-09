package webserver.handler.resource.resolver.statics;

import webserver.handler.resource.resolver.AbstractResolver;
import webserver.http.Content;
import webserver.http.ContentType;

public class StaticResolver extends AbstractResolver {

    private final StaticTypes staticTypes;

    private final ContentType defaultType;

    public StaticResolver(String prefix, StaticTypes staticTypes, ContentType defaultType) {
        super(prefix);
        this.staticTypes = staticTypes;
        this.defaultType = defaultType;
    }

    @Override
    public Content resolve(String path) {
        ContentType contentType = staticTypes.getContentType(path, defaultType);

        return new Content(contentType, getData(path));
    }
}