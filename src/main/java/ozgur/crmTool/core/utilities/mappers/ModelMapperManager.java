package ozgur.crmTool.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

/**
 * Concrete implementation of ModelMapperService that provides configured
 * ModelMapper instances for request and response mappings.
 *
 * Uses different matching strategies for requests (strict) vs responses (loose)
 * to handle object mapping with appropriate level of strictness for each direction.
 */
@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;

    /**
     * Provides a ModelMapper instance configured for response mappings (Entity → DTO).
     * Uses LOOSE matching strategy to:
     * - Ignore case differences in property names
     * - Allow partial matches
     * - Be more forgiving with complex object graphs
     *
     * Configuration:
     * - Ambiguity ignored (skips properties that could map to multiple sources)
     * - Loose matching strategy
     *
     * @return ModelMapper instance optimized for response mapping
     */
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    /**
     * Provides a ModelMapper instance configured for request mappings (DTO → Entity).
     * Uses STANDARD matching strategy to:
     * - Require exact property name matches
     * - Provide more predictable mapping behavior
     * - Prevent accidental data loss during conversion
     *
     * Configuration:
     * - Ambiguity ignored
     * - Standard matching strategy
     *
     * @return ModelMapper instance optimized for request mapping
     */
    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
