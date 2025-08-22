package ozgur.crmTool.core.utilities.mappers;

import org.modelmapper.ModelMapper;

/**
 * Service interface for ModelMapper operations.
 * Provides standardized methods for object mapping between different layers
 * (e.g., DTOs to Entities and vice versa) with separate configurations
 * for request and response mappings.
 *
 * Implementations should provide properly configured ModelMapper instances
 * optimized for either incoming requests or outgoing responses.
 */
public interface ModelMapperService {
    /**
     * Provides a ModelMapper instance configured for response mappings.
     * Typically used when converting entities to DTOs for API responses.
     *
     * @return Pre-configured ModelMapper instance for response mapping
     */
    ModelMapper forResponse();

    /**
     * Provides a ModelMapper instance configured for request mappings.
     * Typically used when converting DTOs to entities for API requests.
     *
     * @return Pre-configured ModelMapper instance for request mapping
     */
    ModelMapper forRequest();

    ModelMapper forContact();
}
