package com.mlieshoff.blueprint.rest;

import com.mlieshoff.blueprint.service.ExampleService;
import com.mlieshoff.blueprint.service.ExampleServiceDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ExampleRestController {

    private final ExampleService exampleService;

    @Operation(summary = "Just display OK")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Displays a list of examples",
                        content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExampleRestDto.class))
                        })
            })
    @GetMapping(value = "examples/list", produces = "application/json")
    public List<ExampleRestDto> listExamples() {
        List<ExampleRestDto> result = new ArrayList<>();
        for (ExampleServiceDto exampleServiceDto : exampleService.list()) {
            result.add(
                    ExampleRestMapper.INSTANCE.exampleServiceDtoToExampleRestDto(
                            exampleServiceDto));
        }
        return result;
    }
}
