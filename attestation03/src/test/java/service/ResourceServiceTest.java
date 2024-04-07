package service;

import model.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ResourceRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ResourceServiceTest {

    private final ResourceRepository resourceRepository = mock(ResourceRepository.class);
    private ResourceService resourceService;

    @BeforeEach
    void setUp() {
        resourceService = new ResourceService(resourceRepository);
    }

    @Test
    void getAllResources_ShouldReturnAllResources() {
        when(resourceRepository.findAll()).thenReturn(List.of(new Resource()));

        List<Resource> resources = resourceService.getAllResources();

        assertThat(resources).isNotNull();
        assertThat(resources.size()).isGreaterThan(0);
        verify(resourceRepository).findAll();
    }

    @Test
    void getResourceById_ShouldReturnResourceWhenExists() {
        Resource resource = new Resource();
        when(resourceRepository.findById(1L)).thenReturn(Optional.of(resource));

        Optional<Resource> foundResource = resourceService.getResourceById(1L);

        assertThat(foundResource).isPresent();
        verify(resourceRepository).findById(1L);
    }

    @Test
    void createResource_ShouldSaveResource() {
        Resource resource = new Resource();
        when(resourceRepository.save(any(Resource.class))).thenReturn(resource);

        Resource savedResource = resourceService.createResource(resource);

        assertThat(savedResource).isNotNull();
        verify(resourceRepository).save(resource);
    }

    @Test
    void updateResource_ShouldUpdateExistingResource() {
        Resource existingResource = new Resource();
        Resource resourceDetails = new Resource();
        resourceDetails.setTitle("New Title");
        resourceDetails.setDescription("New Description");
        resourceDetails.setType("New Type");
        resourceDetails.setUrl("http://new.url");

        when(resourceRepository.findById(1L)).thenReturn(Optional.of(existingResource));
        when(resourceRepository.save(any(Resource.class))).thenReturn(existingResource);

        Resource updatedResource = resourceService.updateResource(1L, resourceDetails);

        assertThat(updatedResource.getTitle()).isEqualTo("New Title");
        assertThat(updatedResource.getDescription()).isEqualTo("New Description");
        assertThat(updatedResource.getType()).isEqualTo("New Type");
        assertThat(updatedResource.getUrl()).isEqualTo("http://new.url");
        verify(resourceRepository).save(existingResource);
    }

    @Test
    void deleteResource_ShouldThrowIfNotExists() {
        when(resourceRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> resourceService.deleteResource(1L));

        assertThat(exception.getMessage()).contains("Resource not found with id 1");
        verify(resourceRepository).findById(1L);
    }

    @Test
    void deleteResource_ShouldDeleteResourceWhenExists() {
        Resource resource = new Resource();
        when(resourceRepository.findById(1L)).thenReturn(Optional.of(resource));

        resourceService.deleteResource(1L);

        verify(resourceRepository).delete(resource);
    }
}
